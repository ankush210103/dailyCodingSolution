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
    int first;
    int second;
    Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
 }
class Solution {
    public static Pair solve(TreeNode root){
        if(root == null) return new Pair(0,0);
        
        Pair lst = solve(root.left);
        Pair rst = solve(root.right);
        int height = 1 + Math.max(lst.first,rst.first);
        int diameter = Math.max(lst.first+rst.first,Math.max(lst.second,rst.second));
        return new Pair(height,diameter);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        Pair res = solve(root);
        return res.second;
    }
}