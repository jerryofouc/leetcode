package jerryofouc.github.io;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 3/23/14
 * Time: 21:35
 * To change this template use File | Settings | File Templates.
 */
public class ConvertSortedListBinarySearchTree {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    // Definition for binary tree
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (ListNode h = head; h != null; h = h.next) {
            arrayList.add(h.val);
        }

        Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);

        return getBST(array, 0, array.length - 1);

    }

    private TreeNode getBST(Integer[] array, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            TreeNode root = new TreeNode(array[mid]);
            root.left = getBST(array, start, mid-1);
            root.right = getBST(array, mid+1, end);
            return root;
        } else {
            return null;
        }
    }

}
