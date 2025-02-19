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
    class Pair{
        TreeNode first;
        int second;
        Pair(TreeNode first,int second){
            this.first = first;
            this.second = second;
        }
    }

    public void solve(TreeNode root,List<Integer> res){
      
        Stack<Pair> st = new Stack<>();
        if(root != null){
            st.push(new Pair(root,0));
        }
        while(!st.isEmpty()){
            Pair temp = st.pop();
            if(temp.first == null) continue;
            if(temp.second == 1){
                res.add(temp.first.val);
            }else{
            if(temp.first.right != null){
            st.push(new Pair(temp.first.right,0));
            }
            st.push(new Pair(temp.first,1));
            if(temp.first.left != null){
            st.push(new Pair(temp.first.left,0));
            }
        }
    }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> res = new ArrayList<>();
       solve(root,res);
       return res;
    }
}