package jerryofouc.github.io;

/**
 * Created by xiaojiezhang on 11/8/16.
 */
public class ReverseNodesInKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1){
            return head;
        }
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode curPre = preHead;
        ListNode curSuffix = preHead;
        while (curPre != null && curPre.next != null){
            for(int i=0;i<k;i++){
                if(curSuffix.next != null){
                    curSuffix = curSuffix.next;
                }else {
                    return preHead.next;
                }
            }
            ListNode pp = curPre.next;
            while (curPre.next != curSuffix){
                ListNode curPreNext = curPre.next;
                curPre.next = curPreNext.next;
                curPreNext.next = curSuffix.next;
                curSuffix.next = curPreNext;
            }
            curPre = pp;
            curSuffix = pp;
        }
        return preHead.next;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        reverseKGroup(Utils.getListNode(a),2);

    }

}
