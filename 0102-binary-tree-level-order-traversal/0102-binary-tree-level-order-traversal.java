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
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            List<Integer> response = new ArrayList<>();
            int levelSize = q.size();
            for(int i=0;i<levelSize;i++){
                TreeNode node = q.poll();
                response.add(node.val);

                if(node.left != null){
                    q.offer(node.left);
                }

                if(node.right != null){
                    q.offer(node.right);
                }
            }
            res.add(response);
        }

      
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> response = new ArrayList<>();
        solve(root,res);
        return res;
    }
}