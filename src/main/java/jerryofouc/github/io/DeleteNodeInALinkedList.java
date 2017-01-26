package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/26/17.
 */
public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
