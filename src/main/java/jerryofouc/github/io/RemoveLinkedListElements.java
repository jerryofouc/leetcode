package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/21/17.
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode preHead = new ListNode(1);
        preHead.next = head;
        ListNode h = preHead;
        while (h.next!= null){
            if(h.next.val == val){
                h.next = h.next.next;
            }else {
                h = h.next;
            }
        }
        return preHead.next;

    }
}
