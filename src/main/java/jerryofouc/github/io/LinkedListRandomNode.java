package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by xiaojiez on 2/28/17.
 */
public class LinkedListRandomNode {
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    private List<Integer> list = new ArrayList<>();
    public LinkedListRandomNode(ListNode head) {
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}
