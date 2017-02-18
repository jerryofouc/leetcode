package jerryofouc.github.io;

/**
 * Created by xiaojiez on 2/18/17.
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next == null){
            return head;
        }
        ListNode iHead = head;
        ListNode jHead = head.next;

        while (jHead!=null && jHead.next != null){
            ListNode tmp = jHead.next;
            jHead.next = tmp.next;
            tmp.next = iHead.next;
            iHead.next = tmp;
            iHead = iHead.next;
            jHead = jHead.next;
        }
        return head;
    }
}
