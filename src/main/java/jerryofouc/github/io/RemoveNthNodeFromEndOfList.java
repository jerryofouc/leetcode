package jerryofouc.github.io;

/**
 * Created by xiaojiezhang on 11/5/16.
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode a = head;
        for(int i=0;i<n;i++){
            a = a.next;
        }
        if(a.next == null){
            return head.next;
        }

        ListNode b = head;
        while (a.next.next != null){
            a = a.next;
            b = b.next;
        }

        b.next = b.next.next;
        return head;

    }
}
