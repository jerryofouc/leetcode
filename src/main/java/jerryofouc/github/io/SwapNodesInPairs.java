package jerryofouc.github.io;

/**
 * Created by xiaojiezhang on 11/8/16.
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode cur = preHead;
        while (cur.next != null && cur.next.next != null){
            ListNode next = cur.next;
            ListNode nextNext = cur.next.next;
            cur.next = nextNext;
            next.next = nextNext.next;
            nextNext.next = next;
            cur = cur.next.next;
        }
        return preHead.next;
    }
}
