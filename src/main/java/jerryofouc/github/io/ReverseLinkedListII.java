package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 4/7/14
 * Time: 20:36
 * To change this template use File | Settings | File Templates.
 */
public class ReverseLinkedListII {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode virtualHead = new ListNode(-1);
        virtualHead.next = head;
        int index = 0;
        ListNode first = virtualHead;
        for(index = 0;index != m-1;index++){
            first = first.next;
        }

        ListNode cur = first.next;
        for(int k = m;k<=n-1;k++){
            ListNode toForwardNode = cur.next;
            cur.next = toForwardNode.next;
            toForwardNode.next = first.next;
            first.next = toForwardNode;
        }

        return virtualHead.next;
    }

    public static void main(String args[]){
        int[] test = {1,2,3};
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        for(int i=0;i<test.length;i++){
            ListNode listNode = new ListNode(test[i]);
            tail.next = listNode;
            tail = tail.next;
        }
        reverseBetween(head.next,1,3);
    }



}
