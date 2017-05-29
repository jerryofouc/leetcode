package jerryofouc.github.io;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaojiez on 5/28/17.
 */
public class ArrayNesting {
    public static int arrayNesting(int[] nums) {
        Set<Integer> totalSet = new HashSet<>();
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int k = i;
            if(!totalSet.contains(nums[k])){
                set.clear();
                while (!set.contains(nums[k])){
                    set.add(nums[k]);
                    k = nums[k];
                }
                max = Math.max(set.size(),max);
                totalSet.addAll(set);
            }

        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/tmp/a.txt")));
        String line = bufferedReader.readLine();
        String[] a = line.split(",");
        int[] nums = new int[a.length];
        for(int i=0;i<a.length;i++){
            nums[i] = Integer.parseInt(a[i]);
        }


        long t1 = System.currentTimeMillis();
        System.out.println(arrayNesting(nums));
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }
}
