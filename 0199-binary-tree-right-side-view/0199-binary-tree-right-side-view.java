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
    public static int maxL = Integer.MIN_VALUE;
    public static void solve(TreeNode root,int l,List<Integer> res){
        if(root == null) return;
        if(l > maxL){
            res.add(root.val);
            maxL = l;
        }
        solve(root.right,l+1,res);
        solve(root.left,l+1,res);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        maxL = -1;
        solve(root,0,res);
        return res;

    }
}