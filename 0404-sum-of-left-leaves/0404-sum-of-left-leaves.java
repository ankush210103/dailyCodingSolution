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

    public static int solve(TreeNode root){
        if(root == null){
            return 0;
        }
        int sm =0;
        if(root.left!= null && root.left.left == null && root.left.right == null){
            sm+=root.left.val;
        }
       sm+= solve(root.left);
       sm += solve(root.right);
       return sm;
    }


    public int sumOfLeftLeaves(TreeNode root) {
        
        int res = solve(root);
        return res;
    }
}