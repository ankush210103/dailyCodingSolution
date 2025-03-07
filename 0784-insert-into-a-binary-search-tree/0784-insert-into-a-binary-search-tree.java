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
    public TreeNode insertIntoBST(TreeNode root, int val) {

        if(root == null) return new TreeNode(val,null,null);
        TreeNode prev = null;
        TreeNode node  =root;
        while(node != null){
            prev = node;
            if(node.val<val){
                node = node.right;
            }else{
                node = node.left;
            }
        }

        if(prev.val < val){
            prev.right = new TreeNode(val,null,null);
        }else{
            prev.left = new TreeNode(val,null,null);
        }

        return root;
        
    }
}