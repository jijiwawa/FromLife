package leetcode;
class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode p = head;
        ListNode q = head.next;
        ListNode r = q.next;
        q.next=p;
        p.next=swapPairs(r);
        return q;
    }
}
public class leetcode24 {
}
