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
    public static boolean solve(TreeNode root,int sm,int target){
        if(root == null){
           
            return false;
        }
        if(root.left == null && root.right == null){
           return (sm+root.val) == target;
        }
      boolean left =  solve(root.left,sm+root.val,target);
      boolean right =  solve(root.right,sm+root.val,target);
      return left || right;


    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        boolean result = solve(root,0,targetSum);
        return result;
    }
}