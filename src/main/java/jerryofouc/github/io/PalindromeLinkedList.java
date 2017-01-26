package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/26/17.
 */
public class PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        ListNode preHeader = new ListNode(1);
        preHeader.next = head;
        ListNode cur = preHeader.next;
        int i=0;
        while (cur!=null){
            i++;
            cur = cur.next;
        }

        int k = i/2;
        cur = preHeader;
        for(int j =0;j<k;j++){
            ListNode temp = cur.next;
            cur.next = cur.next.next;
            temp.next = preHeader.next;
            preHeader.next = temp;
            cur = cur.next;
        }


        int s = k;
        if(i%2==1){
            s = k+1;
        }


        ListNode cur2 = preHeader.next;
        for(int j=0;j<s;j++){
            cur2 = cur2.next;
        }

        ListNode cur1 = preHeader.next;

        while (cur1 != null && cur2!= null){
            if(cur1.val != cur2.val){
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }


        return true;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,1};

        ListNode preHeader = new ListNode(1);
        ListNode cur = preHeader;
        for(int i=0;i<a.length;i++){
            ListNode listNode = new ListNode(a[i]);
            cur.next = listNode;
            cur = cur.next;
        }

        System.out.println(isPalindrome(preHeader.next));
    }


}
