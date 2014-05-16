package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 5/16/14
 * Time: 11:12
 * To change this template use File | Settings | File Templates.
 */
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode last = null;
        while (cur != null) {
            if (last != null && cur.val == last.val) {
                last.next = cur.next;
                cur = cur.next;
            } else {
                last = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
