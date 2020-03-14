package leetcode;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /*
        i 指针指向l1 ， j 指针指向l2
         */
        ListNode i = l1;
        ListNode j = l2;
        if (i==null){
            return j;
        }
        if (j==null){
            return i;
        }

        ListNode temp;
        if (i.val<=j.val){
            temp=i;
            i=i.next;
        }else {
            temp=j;
            j=j.next;
        }
        ListNode result  = temp;
        while (i!=null&&j!=null){
            if (i.val<=j.val){
                temp.next=i;
                i=i.next;
            }else {
                temp.next=j;
                j=j.next;
            }
            temp=temp.next;
        }
        if (i!=null){
            temp.next=i;
        }
        if (j!=null){
            temp.next=j;
        }
        return result;
    }
}

public class leetcode21 {
}
