package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 5/8/14
 * Time: 17:48
 * To change this template use File | Settings | File Templates.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode head1 = new ListNode(-1);
        ListNode head2 = new ListNode(-1);
        ListNode tail2 = head2;
        ListNode tail1 = head1;
        while(head != null){
            if(head.val < x){
                tail1.next = head;
                head = head.next;
                tail1 = tail1.next;
                tail1.next = null;
            }else{
                tail2.next = head;
                head = head.next;
                tail2 = tail2.next;
                tail2.next = null;
            }
        }
        tail1.next = head2.next;
        return head1.next;
    }
}
