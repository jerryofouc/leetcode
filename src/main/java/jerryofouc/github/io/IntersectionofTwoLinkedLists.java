package jerryofouc.github.io;/**
 * Created by xiaojiez on 1/17/17.
 */

public class IntersectionofTwoLinkedLists  {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int la = 0;
        ListNode ha = headA;
        while (ha != null){
            ha = ha.next;
            la++;
        }

        int lb = 0;
        ListNode hb = headB;
        while (hb != null){
            lb++;
            hb = hb.next;
        }

        if(la == 0|| lb == 0){
            return null;
        }

        if(la<lb){
            int step = lb-la;
            while (step>0){
                headA = headA.next;
                step--;
            }
        }

        if(la>lb){
            int step = la-lb;
            while (step>0){
                headB = headB.next;
                step--;
            }
        }

        while (headA != null && headB != null){
            if(headA == headB){
                return headA;
            }else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;

    }
    public static void main(String[] args) {

    }
}
