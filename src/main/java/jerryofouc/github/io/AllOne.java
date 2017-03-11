package jerryofouc.github.io;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xiaojiez on 3/11/17.
 */
public class AllOne {
    static class DNode {
        public DNode(int val) {
            this.val = val;
        }

        int val;
        Set<String> set = new HashSet<>();
        DNode last;
        DNode next;
    }

    Map<String, DNode> map = new HashMap<>();
    DNode value1Node = new DNode(1);
    DNode head = new DNode(Integer.MIN_VALUE);
    DNode tail = new DNode(Integer.MAX_VALUE);

    /**
     * Initialize your data structure here.
     */
    public AllOne() {
        head.next = value1Node;
        value1Node.last = head;
        value1Node.next = tail;
        tail.last = value1Node;
    }
    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        DNode dNode = map.get(key);
        if (dNode == null) {
            value1Node.set.add(key);
            map.put(key,value1Node);
        } else {
            DNode cur = dNode;
            DNode next = cur.next;
            if (next.val == dNode.val + 1 && next != tail) {
                next.set.add(key);
                map.put(key, next);
            } else {
                DNode nnext = new DNode(cur.val + 1);
                nnext.set.add(key);
                nnext.last = cur;
                nnext.next = next;
                next.last = nnext;
                cur.next = nnext;
                map.put(key, nnext);
            }
            cur.set.remove(key);
            if(cur != value1Node && cur.set.size() == 0){
                cur.last.next = cur.next;
                cur.next.last = cur.last;
            }
        }
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        DNode dNode = map.get(key);
        if (dNode != null) {
            DNode cur = dNode;
            cur.set.remove(key);
            if(cur == value1Node){
                map.remove(key);
            }else {
                if(cur.last.val == cur.val-1){
                    cur.last.set.add(key);
                    map.put(key,cur.last);
                }else {
                    DNode llNode = new DNode(cur.val-1);
                    llNode.set.add(key);
                    llNode.next = cur;
                    llNode.last = cur.last;
                    cur.last.next = llNode;
                    cur.last = llNode;
                    map.put(key,llNode);
                }
                if(cur.set.size() == 0){
                    cur.last.next = cur.next;
                    cur.next.last = cur.last;
                }
            }
        }
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        Set<String> maxSet = tail.last.set;
        if(maxSet.size() == 0){
            return "";
        }else {
            for(String a : maxSet){
                return a;
            }
        }
        throw new RuntimeException();
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        Set<String> minSet = value1Node.set;
        if(minSet.size() == 0){
            if(value1Node.next != tail){
                for(String a : value1Node.next.set){
                    return a;
                }
            }
            return "";
        }else {
            for(String a : minSet){
                return a;
            }
        }
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("b");
        allOne.dec("b");
        allOne.dec("b");
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());
    }
}
