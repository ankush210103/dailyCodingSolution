/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root== null) return null;
        if((root.val == p.val) || (root.val == q.val)) return root;

        TreeNode lst = lowestCommonAncestor(root.left,p,q);
        TreeNode rst = lowestCommonAncestor(root.right,p,q);
        if(lst!= null && rst!= null) return root;
       return lst!=null ? lst : rst;
        
    }
}