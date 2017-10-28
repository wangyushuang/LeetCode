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
import java.util.ArrayList;
public class deteCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode curr=head;
        ArrayList<ListNode> list=new ArrayList<ListNode>();
        while(curr!=null){
            if(list.contains(curr))
                return curr;
            list.add(curr);
            curr=curr.next;
        }
        return null;
    }
}