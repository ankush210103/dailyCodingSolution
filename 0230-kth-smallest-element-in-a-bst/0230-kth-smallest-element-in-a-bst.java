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
    public static int ans = -1;
    public static int count = 1;
    public static void solve(TreeNode root,int k){
        if(root == null) return;

        solve(root.left,k);
        count = count+1;
        if(count == k){
            ans = root.val;
            return ;
        }
        solve(root.right,k);
    }


    public int kthSmallest(TreeNode root, int k) {
         ans = -1;
         count = 0;
        solve(root,k);
     
        return ans;
    }
}