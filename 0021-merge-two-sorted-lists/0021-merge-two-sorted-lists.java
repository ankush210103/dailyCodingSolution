class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ansNode = new ListNode(0);
        ListNode list = ansNode;
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        if(temp1 == null && temp2 == null){
            return null;
        }

        while(temp1!= null && temp2!= null){
            if(temp1.val <= temp2.val ){
                list.next = temp1;
               
                temp1 = temp1.next;
            }else{
                list.next = temp2;
               
                temp2 = temp2.next;
            }
            list = list.next;
        }

        while(temp1!= null){
            list.next = temp1;
            temp1 = temp1.next;
            list = list.next;
           
        }
        while(temp2!= null){
            list.next = temp2;
            temp2 = temp2.next;
            list = list.next;
            
        }

        // ListNode temp3 = list;
        // while(temp3!= null){
        //     System.out.print(temp3.val+" ");
        //     temp3 = temp3.next;
        // }
       
        return ansNode.next;
    
    }
}