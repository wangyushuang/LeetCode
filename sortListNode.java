/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//归并
public class sortListNode {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode result=new ListNode(0);
        ListNode itRes=result;
        //fast走两步，slow走一步，fast走完时，slow在中点
        ListNode fast=head,slow=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        //截断
        fast=slow;
        slow=slow.next;
        fast.next=null;
        ListNode p1=sortList(head);
        ListNode p2=sortList(slow);
        while(p1!=null && p2!=null){
            if(p1.val<p2.val){
                itRes.next=p1;
                p1=p1.next;
            }
            else{
                itRes.next=p2;
                p2=p2.next;
            }
            itRes=itRes.next;
        }
        if(p1!=null)
            itRes.next=p1;
        if(p2!=null)
            itRes.next=p2;
        return result.next;
    }
}