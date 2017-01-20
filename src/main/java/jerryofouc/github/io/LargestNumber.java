package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xiaojiez on 1/19/17.
 */
public class LargestNumber {
    public static String largestNumber(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }

        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                String a = o1+""+o2;
                String b = o2+"" + o1;
                for(int i=0;i<a.length();i++){
                    if(a.charAt(i) > b.charAt(i)){
                        return -1;
                    }else if(a.charAt(i) < b.charAt(i)){
                        return 1;
                    }
                }
                return 0;
            }
        });

        String result = "";
        boolean isFirstZero = true;
        for(int i=0;i<list.size();i++){
            if(!isFirstZero){
                result += list.get(i);
            }else {
                if(list.get(i) != 0){
                    result += list.get(i);
                    isFirstZero = false;
                }
            }
        }
        if(result.equals("")){
            return 0+"";
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums));
    }
}
