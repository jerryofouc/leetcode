package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 6/18/14
 * Time: 16:42
 * To change this template use File | Settings | File Templates.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reNode = new ListNode(0);
        ListNode tail = reNode;

        int carry = 0;
        while(l1 != null || l2 != null){
            ListNode temp = new ListNode((carry+(l1 == null?0:l1.val)+(l2==null?0:l2.val))%10);
            carry = (carry+(l1 == null?0:l1.val)+(l2==null?0:l2.val))/10;
            tail.next = temp;
            tail = tail.next;

            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }

        }

        if(carry != 0){
            tail.next = new ListNode(carry);
        }

        return reNode.next;
    }
}
