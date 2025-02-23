/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static long prev = Long.MIN_VALUE;
    public static boolean ans = true;
    public static void solve(TreeNode root){
        if(root == null) return ;
        solve(root.left);
        if(root.val <= prev){
            ans = false;
            return;
        }
        prev = root.val;
        solve(root.right);
    }


    public boolean isValidBST(TreeNode root) {
      ans = true;
        prev = Long.MIN_VALUE;
        solve(root);
        return ans;
    
    }
}