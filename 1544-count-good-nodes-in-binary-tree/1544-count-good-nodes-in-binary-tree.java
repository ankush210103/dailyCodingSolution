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

    public static int solve(TreeNode root,int maxSoFar){
        if(root == null) return 0;
        int count =0;
        if(root.val >=maxSoFar){
            count =1;
            maxSoFar = root.val;
        }
        return count + solve(root.left,maxSoFar) + solve(root.right,maxSoFar);

    }
    public int goodNodes(TreeNode root) {
        int res = solve(root,root.val);
        return res;
        
    }
}