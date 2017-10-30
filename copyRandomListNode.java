/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class copyRandomListNode {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)
            return null;
        RandomListNode list=new RandomListNode(head.label);
        RandomListNode clist=list;
        RandomListNode p=head;
        while(p!=null){
            if(p.next!=null)
                clist.next=new RandomListNode(p.next.label);
            if(p.random!=null)
                clist.random=new RandomListNode(p.random.label);
            clist=clist.next;
            p=p.next;
        }
        return list;
    }
}