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
  

    public void solve(TreeNode root,List<Integer> res){
        Stack<TreeNode> st = new Stack<>();
       
        while(root != null){
            st.push(root);
            root = root.left;
        }
        while(!st.isEmpty()){
            TreeNode temp = st.pop();
            res.add(temp.val);
           
                temp = temp.right;
            
            while(temp!= null){
                st.push(temp);
                temp = temp.left;
            }


        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> res = new ArrayList<>();
       solve(root,res);
       return res;
    }
}