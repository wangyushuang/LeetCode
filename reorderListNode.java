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
public class reorderListNode {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null)
            return;
        ListNode p=head;
        ListNode q=head;
        int num1=0;
        while(q.next.next!=null){//指针移到倒数第二位
            q=q.next;
            num1++;
        }
        int num2=0;
        while(num2<num1){
            ListNode tmp=p.next;//中间部分
            p.next=q.next;
            q.next=null;
            p.next.next=tmp;
            p=p.next.next;
            num1--;
            num2++;
            q=tmp;
            while(q!=null && q.next!=null && q.next.next!=null)//移动到倒数第二位
                q=q.next;
        }
    }
}
