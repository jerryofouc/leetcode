package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 2/21/14
 * Time: 22:03
 * To change this template use File | Settings | File Templates.
 */
public class ReorderList {
   static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while(fast != null && fast.next!=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        //rotate
        ListNode head2 = new ListNode(0);
        while(slow != null){
            ListNode temp = slow.next;
            slow.next = head2.next;
            head2.next = slow;
            slow = temp;
        }


        ListNode p1 = head;
        ListNode p2 = head2.next;
        while(p1.next != null && p2 !=null){
            ListNode temp = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = temp;
        }
        if(p1.next == null){
            p1.next = p2;
        }
    }
    public static void main(String args[]){
        Integer aa[] = {1,2,3};
        ListNode head = new ListNode(0);
        ListNode last = head;
        for(Integer i : aa){
            ListNode l = new ListNode(i);
            last.next = l;
            last = last.next;
        }
        reorderList(head.next);
        for(last = head.next;last !=null;last = last.next){
            System.out.println(last.val);
        }
    }
}
