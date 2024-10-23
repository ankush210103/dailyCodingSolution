/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      ListNode temp1 = headA;
      ListNode temp2 = headB;

      while(temp1 != null && temp2!= null){
        temp1 = temp1.next;
        temp2 = temp2.next;
      }
      
      if(temp1 == null){
        int count =0;
        while(temp2!= null){
            count++;
            temp2 = temp2.next;
        }
        while(count>0){
            headB = headB.next;
            count--;
        }
        
      }else{
        int count =0;
        while(temp1!= null){
            count++;
            temp1 = temp1.next;
        }
        while(count>0){
            headA = headA.next;
            count--;
        }
       
      }
      while(headA != headB){
        
        headA = headA.next;
        headB = headB.next;
      }
      return headA;
}
}