package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/21/17.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode preHeader = new ListNode(1);
        preHeader.next = head;
        ListNode x = preHeader.next;
        while (x.next != null){
            ListNode temp = x.next;
            x.next = x.next.next;
            temp.next = preHeader.next;
            preHeader.next = temp;
        }
        return preHeader.next;
    }
}
