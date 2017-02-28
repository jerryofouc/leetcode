package jerryofouc.github.io;

import java.util.*;

/**
 * Created by xiaojiez on 2/28/17.
 */
public class RandomizedCollection {

    private HashMap<Integer,List<Integer>> map;
    private List<Integer> list;
    private int count;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean ret = !map.containsKey(val);
        List<Integer> indexList = map.get(val);
        if(indexList == null){
            indexList = new ArrayList<>();
        }
        list.add(val);
        indexList.add(list.size()-1);
        map.put(val,indexList);
        count++;
        return ret;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean ret = map.containsKey(val);
        if(ret){
            List<Integer> indexList = map.get(val);
            int index = indexList.get(indexList.size()-1);
            list.set(index,null);
            indexList.remove(indexList.size()-1);
            if(indexList.size() == 0){
                map.remove(val);
            }
            count--;
            if(list.size() > 1000 &&  count <list.size()/2){
                list = new ArrayList<>();
                HashMap<Integer,List<Integer>> newMap = new HashMap<>();
                for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
                    List<Integer> newIndexList = new ArrayList<>();
                    for(Integer k :entry.getValue()){
                        list.add(entry.getKey());
                        newIndexList.add(list.size()-1);
                    }

                    newMap.put(entry.getKey(),newIndexList);
                }
                map = newMap;
            }

        }
        return ret;
    }

    /** Get a random element from the collection. */
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
        RandomizedCollection randomizedSet = new RandomizedCollection();
        System.out.println(randomizedSet.insert(1));;
        System.out.println(randomizedSet.remove(1));;
        System.out.println(randomizedSet.insert(1));;
        System.out.println(randomizedSet.getRandom());

        randomizedSet.remove(1);
        System.out.println(randomizedSet.getRandom());

    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */