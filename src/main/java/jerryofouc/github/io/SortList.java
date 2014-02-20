package jerryofouc.github.io;

import java.util.Random;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = head;
        ListNode l = head.next;
        while(l != null && l.next!=null){
            p = p.next;
            l = l.next.next;
        }
        ListNode right = sortList(p.next);
        p.next = null;
        ListNode left = sortList(head);
        return merge(left,right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode last = head;
        while(left !=null && right !=null){
            if(left.val < right.val){
                last.next = left;
                left = left.next;
            }else{
                last.next = right;
                right = right.next;
            }
            last = last.next;
        }
        if(left != null){
            last.next = left;
        }else{
            last.next = right;
        }
        return head.next;
    }


    class Pair {
        ListNode start;
        ListNode end;

        Pair(ListNode start, ListNode end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String args[]) {
        Integer testCases[] = {4,19,14,5,-3,1,8,5,11,15};
        ListNode head = null;
        ListNode cur = head;
        for (Integer i:testCases) {
            ListNode listNode = new ListNode(i);
            if(head == null ){
                head = listNode;
                cur = head;
            }
            cur.next = listNode;
            cur = cur.next;
        }
        ListNode h = new SortList().sortList(head);
        System.out.println(h);

    }

}
