package jerryofouc.github.io;

import java.util.Stack;

/**
 * Created by xiaojiez on 3/13/17.
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        while (l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }

        Stack<Integer> s2 = new Stack<>();

        while (l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode header = new ListNode(-1);
        int carry = 0;
        while (!s1.isEmpty() && !s2.isEmpty()){
            int a = s1.pop()+s2.pop()+carry;
            int val = (a)%10;
            carry = (a)/10;
            ListNode l = new ListNode(val);
            l.next = header.next;
            header.next = l;
        }

        while (!s1.isEmpty()){
            int a = s1.pop()+carry;
            int val = (a)%10;
            carry = (a)/10;
            ListNode l = new ListNode(val);
            l.next = header.next;
            header.next = l;
        }

        while (!s2.isEmpty()){
            int a= (s2.pop()+carry);
            int val = (a)%10;
            carry = (a)/10;
            ListNode l = new ListNode(val);
            l.next = header.next;
            header.next = l;
        }

        if(carry != 0){
            ListNode l = new ListNode(carry);
            l.next = header.next;
            header.next = l;
        }

        return header.next;

    }
}
