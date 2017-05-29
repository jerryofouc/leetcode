package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaojiez on 5/28/17.
 */
public class MinimumIndexSumofTwoLists {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<list2.length;i++){
            map.put(list2[i],i);
        }
        List<String> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i=0;i<list1.length;i++){
            if(map.containsKey(list1[i])){
                if(map.get(list1[i])+i<min){
                    result.clear();
                    result.add(list1[i]);
                    min = map.get(list1[i])+i;
                }else if(map.get(list1[i])+i==min){
                    result.add(list1[i]);
                }
            }
        }
        String[] a = new String[result.size()];
        for(int i=0;i<result.size();i++){
            a[i] = result.get(i);
        }
        return a;
    }

    public static void main(String[] args) {
        String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = new String[]{"KFC", "Shogun", "Burger King"};
        System.out.println(findRestaurant(list1,list2));
    }
}
