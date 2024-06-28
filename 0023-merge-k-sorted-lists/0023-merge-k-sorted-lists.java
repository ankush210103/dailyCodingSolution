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
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> l = new ArrayList<>();
        for(int i=0;i<lists.length;i++){
            ListNode temp = lists[i];
            while(temp!=null){
                l.add(temp.val);
                temp = temp.next;
            }
        }
        Collections.sort(l);
        System.out.println(l.size());
        ListNode newList = new ListNode(0);
        ListNode dummy = newList;
        for(int i=0;i<l.size();i++){
           ListNode m = new ListNode(l.get(i));
           dummy.next = m;
           dummy = dummy.next;
        }
       if(l.size() == 0){
        return null;
       }
        return newList.next;
    }
}