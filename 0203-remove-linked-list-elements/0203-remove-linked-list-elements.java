/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode ansNode = new ListNode();
        ListNode dummy = ansNode;

        ListNode temp = head;
        while(temp!=null ){
            if(temp.val != val){
                dummy.next = temp;
                dummy = dummy.next;
               
            }
            if(temp.next == null && temp.val == val){
                dummy.next = null;
            }
            temp = temp.next;
        }

        return ansNode.next;
        
    }
}