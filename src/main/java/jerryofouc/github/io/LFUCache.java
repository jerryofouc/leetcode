package jerryofouc.github.io;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaojiez on 3/17/17.
 */
public class LFUCache {
    int capacity;
    int totalCount;
    static class Node{
        public Node(int count,int key, int value) {
            this.count = count;
            this.value = value;
            this.key = key;
        }

        int key;
        Node next;
        Node pre;
        int count;
        int value;
    }
    Map<Integer,Node> valueMap = new HashMap<>();
    Node header = new Node(0,0,0);
    Map<Integer,Node> countMap = new HashMap<>();
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public void put(int key, int value) {
        if(capacity == 0){
            return;
        }

        Node node = valueMap.get(key);

        if(this.totalCount == capacity&&node==null){
            if(header.next == countMap.get(header.next.count)){
                countMap.remove(header.next.count);
            }
            valueMap.remove(header.next.key);
            header.next = header.next.next;
            if(header.next != null){
                header.next.pre = header;
            }

            totalCount--;
        }

        if(node == null){
            node = new Node(1,key,value);
            valueMap.put(key,node);
            if(header.next == null){
                header.next = node;
                node.pre = header;
                countMap.put(1,node);
            }else {
                if(header.next.count == 1){
                    Node cur = countMap.get(1);
                    countMap.put(1,node);
                    node.next = cur.next;
                    if(cur.next!=null){
                        cur.next.pre = node;
                    }
                    node.pre = cur;
                    cur.next = node;
                }else {
                    countMap.put(1,node);
                    node.next = header.next;
                    if(header.next != null){
                        header.next.pre = node;
                    }
                    header.next = node;
                    node.pre = header;
                }
            }
            this.totalCount++;
        }else {
            node.value = value;
            node.count++;
            Node curCountNode = countMap.get(node.count-1);
            Node temp;
            if(curCountNode == node){
                if(curCountNode.pre == header || curCountNode.pre.count != curCountNode.count-1){
                    countMap.remove(curCountNode.count-1);
                }else {
                    countMap.put(curCountNode.count-1,curCountNode.pre);
                }
                temp = curCountNode.pre;
            }else {
                temp = curCountNode;
            }
            if(node.next != null){
                node.next.pre = node.pre;
            }
            node.pre.next = node.next;


            Node nextCountNode = countMap.get(node.count);
            if(nextCountNode == null){
                countMap.put(node.count,node);
                node.next = temp.next;
                if(temp.next != null){
                    temp.next.pre = node;
                }
                temp.next = node;
                node.pre =temp;
            }else {
                node.pre = nextCountNode;
                if(nextCountNode.next != null){
                    nextCountNode.next.pre = node;
                }
                node.next = nextCountNode.next;
                nextCountNode.next = node;
                node.pre = nextCountNode;
                countMap.put(node.count,node);
            }
        }
    }

    public int get(int key) {
        Node node = valueMap.get(key);
        if(node == null){
            return -1;
        }else {
            node.count++;
            Node curCountNode = countMap.get(node.count-1);
            Node temp;
            if(curCountNode == node){
                if(curCountNode.pre == header || curCountNode.pre.count != curCountNode.count-1){
                    countMap.remove(curCountNode.count-1);
                }else {
                    countMap.put(curCountNode.count-1,curCountNode.pre);
                }
                temp = curCountNode.pre;
            }else {
                temp = curCountNode;
            }
            if(node.next != null){
                node.next.pre = node.pre;
            }
            node.pre.next = node.next;


            Node nextCountNode = countMap.get(node.count);
            if(nextCountNode == null){
                countMap.put(node.count,node);
                node.next = temp.next;
                if(temp.next != null){
                    temp.next.pre = node;
                }
                temp.next = node;
                node.pre =temp;
            }else {
                node.pre = nextCountNode;
                if(nextCountNode.next != null){
                    nextCountNode.next.pre = node;
                }
                node.next = nextCountNode.next;
                nextCountNode.next = node;
                node.pre = nextCountNode;
                countMap.put(node.count,node);
            }
            return node.value;
        }
    }

    public static void main(String[] args) {
        case5();
    }

    static void case3(){
        LFUCache cache = new LFUCache(1);

        cache.put(2,1);
        System.out.println(cache.get(2));
        cache.put(3,2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));

    }

    static void case2(){
        LFUCache cache = new LFUCache(2);

        cache.put(3,1);
        cache.put(2,1);
        cache.put(2,1);
        cache.put(4,4);
        cache.get(2);
    }

    static void case1(){
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }

    static void case4(){
        LFUCache cache = new LFUCache(2);
        cache.put(2, 1);
        cache.put(2, 2);
        System.out.println(cache.get(2));       // returns 1
        cache.put(1, 1);    // evicts key 2
        cache.put(4,1);
        System.out.println(cache.get(2));
    }

    static void case5(){
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }


}
