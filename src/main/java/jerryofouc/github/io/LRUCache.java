package jerryofouc.github.io;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 2/17/14
 * Time: 23:09
 * To change this template use File | Settings | File Templates.
 */
public class LRUCache {
    //double linked entry
    private class Entry{
        int key;
        Entry next;
        Entry pre;
        Entry( int key){
            this.key = key;
            next = null;
            pre = null;
        }
    }
    Entry head = new Entry(Integer.MIN_VALUE);
    private class Pair{
        Entry entry;
        Integer value;
    }
    private HashMap<Integer,Pair> map = new HashMap<Integer,Pair>();
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }else {
            Pair pair = map.get(key);
            Entry entry = pair.entry;
            entry.pre.next = entry.next;
            if(entry.next != null){
                entry.next.pre = entry.pre;
            }
            insertFirst(entry);
            return pair.value;
        }
    }

    public void set(int key, int value) {
        if(map.containsKey(key)){//if set, get the key and move it to the first
            Pair pair = map.get(key);
            pair.value = value;
            Entry entry = pair.entry;
            entry.pre.next = entry.next;
            if(entry.next != null){
                entry.next.pre = entry.pre;
            }
            insertFirst(entry);
            return;
        }else{//first check if full, if not full insert, and move it to the first.
            if(map.size() == this.capacity){
                Entry p = head ;
                for(;p.next != null;p=p.next){
                }
                map.remove(p.key);
                p.pre.next = null;

            }
            Entry entry = new Entry(key);
            Pair pair = new Pair();
            pair.entry = entry;
            pair.value = value;
            map.put(key,pair);
            insertFirst(entry);
        }

    }
    private void insertFirst(Entry entry){
        entry.next = head.next;
        entry.pre = head;
        head.next = entry;
        if(entry.next!=null){
            entry.next.pre = entry;
        }
    }

    public static void main(String args[]){
        LRUCache lruCache = new LRUCache(1);
        lruCache.set(2,1);
        System.out.println(lruCache.get(2));;
        lruCache.set(3,2);
        System.out.println(lruCache.get(2));;
        System.out.println(lruCache.get(3));;
    }


}
