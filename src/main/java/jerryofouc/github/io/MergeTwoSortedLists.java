package jerryofouc.github.io;

/**
 * @author zhangxiaojie
 *         2014-11-23 13:12
 *         功能介绍:
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode header = new ListNode(-1);
        ListNode cur = header;
        ListNode n1 = l1;
        ListNode n2 = l2;
        while(n1 != null && n2 != null){
            if(n1.val < n2.val){
                cur.next = n1;
                n1 = n1.next;
            }else {
                cur.next = n2;
                n2 = n2.next;
            }
            cur = cur.next;
        }

        while(n1 != null){
            cur.next = n1;
            n1 = n1.next;
            cur = cur.next;
        }


        while(n2 != null){
            cur.next = n2;
            n2 = n2.next;
            cur = cur.next;
        }

        return header.next;
    }
}
