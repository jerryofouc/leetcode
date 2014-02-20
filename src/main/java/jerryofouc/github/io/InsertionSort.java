package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 2/20/14
 * Time: 22:29
 * To change this template use File | Settings | File Templates.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */


public class InsertionSort {
    public static ListNode  insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head.next;
        head.next = null;

        while (cur != null) {
            ListNode p = head;
            if (head.val > cur.val) {
                ListNode temp = cur.next;
                cur.next = head;
                head = cur;
                cur = temp;
            } else {
                while (p.next != null && p.next.val < cur.val) {
                    p = p.next;
                }
                if (p.next == null) {//last one
                    p.next = cur;
                    cur = cur.next;
                    p = p.next;
                    p.next = null;
                } else {
                    ListNode temp = cur.next;
                    cur.next = p.next;
                    p.next = cur;
                    cur = temp;
                }
            }
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String args[]) {
        Integer l[] = {2, 1};
        ListNode h = null;
        ListNode last = h;
        for (Integer i : l) {
            ListNode p = new ListNode(i);
            if(h == null){
                h = p;
                last = p;
            }else{
                last.next = p;
                last = last.next;
            }
        }
        insertionSortList(h);
    }
}
