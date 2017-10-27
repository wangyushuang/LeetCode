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
//插入当前结点时，大体可分为三种情况：
//1.比头结点小
//2.比尾结点大
//3.介于中间
public class insertionSortListNode {
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode result=new ListNode(head.val);
        ListNode curr=head.next;//当前结点
        while(curr!=null){
            ListNode p=result;
            if(curr.val<=p.val){//当前结点的值小于等于表头的值，则把当前结点当表头
                result=new ListNode(curr.val);
                result.next=p;
            }
            else{
                while(p.next!=null && curr.val>p.next.val)
                    p=p.next;
                if(p.next==null){//p走到了result的尾结点，说明当前结点大于链表result中所有结点的值
                    p.next=new ListNode(curr.val);
                }
                else{//将当前结点插入链表result中
                    ListNode tmp=p.next;
                    p.next=new ListNode(curr.val);
                    p.next.next=tmp;
                }
            }
            curr=curr.next;
        }
        return result;
    }
}