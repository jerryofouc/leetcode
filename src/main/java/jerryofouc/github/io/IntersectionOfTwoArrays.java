package jerryofouc.github.io;

import java.util.*;

/**
 * Created by zhangxiaojie on 5/30/16.
 */
public class IntersectionOfTwoArrays {
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<Integer>();
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])){
                map.put(nums1[i],map.get(nums1[i])+1);
            }else {
                map.put(nums1[i],1);
            }
        }

        for(int i=0;i<nums2.length;i++){
            if(map.containsKey(nums2[i])){
                result.add(nums2[i]);
                if(map.get(nums2[i]) > 1){
                    map.put(nums2[i],map.get(nums2[i])-1);
                }else {
                    map.remove(nums2[i]);
                }
            }


        }
        int[] ret = new int[result.size()];
        int i=0;
        for(Integer s : result){
            ret[i++] = s;
        }
        return  ret;
    }

    public static void main(String[] args) {
        int[] a = {1};
        int[] b = {1,1};
        System.out.println(intersect(a,b));
    }
}
