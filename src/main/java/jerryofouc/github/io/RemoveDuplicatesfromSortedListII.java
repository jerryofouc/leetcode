package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 5/16/14
 * Time: 11:27
 * To change this template use File | Settings | File Templates.
 */
public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode pHead = new ListNode(-1);
        pHead.next = head;

        int lastValue = head.val;
        ListNode lastTail = pHead;
        ListNode cur = head.next;
        while(cur != null){
            if(cur.val == lastValue){
                cur = cur.next;
                while(cur != null && cur.val == lastValue){
                    cur = cur.next;
                }
                lastTail.next = cur;
                if(cur != null){
                    lastValue = cur.val;
                    cur = cur.next;
                }
            }else {
                lastTail = lastTail.next;
                lastValue = cur.val;
                cur = cur.next;
            }
        }
        return pHead.next;
    }
}
