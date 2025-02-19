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
    public  void solve(TreeNode root,List<Integer> res){
       Stack<TreeNode> st = new Stack<>();
        if(root != null) st.push(root);
       while(!st.isEmpty()){
            TreeNode temp = st.pop();
            res.add(temp.val);
            if(temp.right!= null){
                st.push(temp.right);
            }
            if(temp.left!= null){
                st.push(temp.left);
            }
       }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        solve(root,res);
        return res;

        
    }
}