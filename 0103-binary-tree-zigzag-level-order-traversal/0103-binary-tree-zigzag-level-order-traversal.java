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
    public static void solve(TreeNode root,List<List<Integer>> res){
        if(root == null) return;
        Queue<TreeNode> q  = new LinkedList<>();
        q.offer(root);
        boolean flag = true;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> response = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode temp = q.poll();
                response.add(temp.val);
                if(temp.left!= null){
                    q.offer(temp.left);
                }
                if(temp.right != null){
                    q.offer(temp.right);
                }
            }
            if(flag == true){
                res.add(response);
                flag = false;
            }else{
                Collections.reverse(response);
                res.add(response);
                flag = true;
            }
            
        }
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        solve(root,res);
        return res;
    }
}