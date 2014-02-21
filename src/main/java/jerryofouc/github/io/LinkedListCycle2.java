package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 2/21/14
 * Time: 23:31
 * To change this template use File | Settings | File Templates.
 */
public class LinkedListCycle2 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null;
        }else{
            int circleLength = 0;
            ListNode p = slow;
            p = p.next;
            circleLength += 1;
            while(p != slow){
                p = p.next;
                circleLength += 1;
            }

            slow = head;
            fast = head;
            for(int i = 0;i<circleLength;i++){
                fast = fast.next;
            }
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }

    public static void main(String args[]){
        Integer aa[] = {1,2};
        ListNode head = new ListNode(0);
        ListNode last = head;
        for(Integer i : aa){
            ListNode listNode = new ListNode(i);
            last.next = listNode;
            last = last.next;
        }
        ListNode result = detectCycle(head.next);
        System.out.println(result);

    }
}
