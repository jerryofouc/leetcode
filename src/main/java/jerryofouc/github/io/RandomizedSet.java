package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by xiaojiez on 2/28/17.
 */
public class RandomizedSet {
    /** Initialize your data structure here. */
    private HashMap<Integer,Integer> map;
    private ArrayList<Integer> list ;
    private int size ;
    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.size = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            list.add(val);
            map.put(val,list.size()-1);
            size++;
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int index = map.get(val);
            list.set(index,null);
            map.remove(val);
            size--;
            if(list.size() > 1000 &&  size <list.size()/2){
                list = new ArrayList<>();
                HashMap<Integer,Integer> newMap = new HashMap<>();
                for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                    list.add(entry.getKey());
                    newMap.put(entry.getKey(),list.size()-1);
                }
                map = newMap;
            }
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        while (true){
            Integer nextInteger = list.get(random.nextInt(list.size()));
            if(nextInteger != null){
                return nextInteger;
            }
        }
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(3);
        randomizedSet.remove(3);
        randomizedSet.remove(0);
        randomizedSet.insert(3);
        System.out.println(randomizedSet.getRandom());

        randomizedSet.insert(0);
        System.out.println(randomizedSet.getRandom());

    }
}
