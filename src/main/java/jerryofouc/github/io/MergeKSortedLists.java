package jerryofouc.github.io;

/**
 * Created by xiaojiezhang on 11/7/16.
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
       return partition(lists,0,lists.length-1);
    }

    private ListNode partition(ListNode[] lists, int begin, int end) {
        if(begin == end){
            return lists[begin];
        }else if(begin<end){
            int q = begin + (end-begin)/2;
            ListNode p1 = partition(lists,begin,q);
            ListNode p2 = partition(lists,q+1,end);
            return merge(p1,p2);
        }else {
            return null;
        }

    }

    private ListNode merge(ListNode p1, ListNode p2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (p1 != null && p2!=null){
            if(p1.val<=p2.val){
                cur.next = p1;
                p1 = p1.next;
            }else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
            cur.next = null;
        }
        if(p1 != null){
            cur.next = p1;
        }
        if(p2 != null){
            cur.next = p2;
        }
        return head.next;
    }
}
