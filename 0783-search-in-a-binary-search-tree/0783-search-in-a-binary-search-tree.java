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
    public static TreeNode search(TreeNode root,int val){
        TreeNode node = root;

        while(node!= null){
            if(node.val == val){
                return node;
            }
            if(node.val < val){
                node = node.right;
            }else{
                node = node.left;
            }
        }
        return null;
    }


    public TreeNode searchBST(TreeNode root, int val) {
        return search(root,val);
    }
}