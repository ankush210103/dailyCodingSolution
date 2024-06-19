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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return createBST(nums,0,nums.length-1);
        
    }
    public TreeNode createBST(int[] arr,int si,int ei){
        if(si>ei){
            return null;
        }
        int mid =(si+ei)/2;
        TreeNode newNode = new TreeNode(arr[mid]);
        newNode.left = createBST(arr,si,mid-1);
        newNode.right = createBST(arr,mid+1,ei);
        return newNode;
    }
}