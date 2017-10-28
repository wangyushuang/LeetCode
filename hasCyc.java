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
public class hasCyc {
    public boolean hasCycle(ListNode head) {
        ArrayList<ListNode> list=new ArrayList<ListNode>();
        ListNode curr=head;
        while(curr!=null){
            if(list.contains(curr))
                return true;
            list.add(curr);
            curr=curr.next;
        }
        return false;
    }
}