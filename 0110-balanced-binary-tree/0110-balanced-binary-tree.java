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


class Pair{
    boolean first;
    int second;
    Pair(boolean first,int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public static Pair solve(TreeNode root){
         if(root == null) return new Pair(true,0);

        Pair lst = solve(root.left);
        Pair rst = solve(root.right);

        boolean res = lst.first && rst.first && (Math.abs(lst.second-rst.second)<=1);
        int height = 1 + Math.max(lst.second, rst.second);
        return new Pair(res,height);
    }
    public boolean isBalanced(TreeNode root) {
        Pair res = solve(root);
        return res.first;
       


    }
}