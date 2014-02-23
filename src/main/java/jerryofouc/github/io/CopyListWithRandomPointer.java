package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 2/22/14
 * Time: 14:24
 * To change this template use File | Settings | File Templates.
 */
public class CopyListWithRandomPointer {
    static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    ;

    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode p = head;
        while (p != null) {
            RandomListNode temp = new RandomListNode(p.label);
            temp.random = null;
            temp.next = p.next;
            p.next = temp;
            p = temp.next;
        }

        RandomListNode p1 = head;
        RandomListNode p2 = head.next;

        while (p1 != null && p2 != null) {
            if (p1.random != null) {
                p2.random = p1.random.next;
            }
            p1 = p2.next;
            if (p1 != null) {
                p2 = p1.next;
            }
        }
        p1 = head;
        p2 = head.next;
        RandomListNode head2 = p2;
        while(p1!=null && p2!= null){
            p1.next = p2.next;
            p1 = p1.next;
            if(p1 != null){
                p2.next = p1.next;
                p2 = p2.next;
            }else {
                p2.next = null;
            }

        }
        return head2;
    }

    public static void main(String args[]){
        RandomListNode p1  = new RandomListNode(-1);
        RandomListNode p2 = new RandomListNode(1);
        p1.random = p2;
        p1.next = p2;
        copyRandomList(p1);

    }
}
