package jerryofouc.github.io;

/**
 * @author zhangxiaojie
 *         2014-11-23 13:49
 *         功能介绍:
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        int length = 0;
        ListNode c = head;
        while(c != null){
            length++;
            c= c.next;
        }
        n = n%length;
        if(head == null || n == 0){
            return head;
        }

        if( n == 0){
            return head;
        }
        ListNode tail = head;
        for(int i = 1;i<n;i++){
            tail = tail.next;
        }

        ListNode hh = null;
        while(tail.next != null){
            if(hh == null){
                hh = head;
            }else {
                hh = hh.next;
            }
            tail = tail.next;
        }


        if(hh != null){
            tail.next = head;
            head = hh.next;
            hh.next = null;
        }

        return head;
    }
}
