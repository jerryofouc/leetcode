package jerryofouc.github.io;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaojiez on 5/3/17.
 * 解题思路：首先不能遍历，连续数组自然想到使用sum[j]-sum[i],然后又想到使用归并排序，然后再想到合并，合并使用map来进行合并。
 */
public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        if(nums.length == 0){
            return 0;
        }
        int[] sum = new int[nums.length+1];
        sum[0] = 0;
        for(int i=0;i<nums.length;i++){
            sum[i+1] = sum[i] + nums[i];
        }

        return binarySort(sum,0,sum.length-1,k);
    }

    private static int binarySort(int[] sum, int start, int end,int k) {
        int result=0;
        if(start == end){
            return 0;
        }
        int mid = start + (end-start)/2;
        int left = binarySort(sum,start,mid,k);
        int right =  binarySort(sum,mid+1,end,k);
        int i=start,j = end;
        int t = 0;
        boolean shouldBreak = false;
        Map<Integer,Integer> map = new HashMap<>();
        for(i=start;i<=mid;i++){
            map.put(sum[i],map.getOrDefault(sum[i],0)+1);
        }

        for(j=mid+1;j<=end;j++){
            result += map.getOrDefault(sum[j]-k,0);
        }

        int[] temp = new int[end-start+1];
         t=0;
        i=start;
        j=mid+1;
        while (i<=mid&&j<=end){
            if(sum[i]<sum[j]){
                temp[t++] = sum[i++];
            }else {
                temp[t++] = sum[j++];
            }
        }

        while (i<=mid){
            temp[t++] = sum[i++];
        }

        while (j<=end){
            temp[t++] = sum[j++];
        }
        System.arraycopy(temp,0,sum,start,end-start+1);
        return left+right+result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(subarraySum(nums,2));
    }


}
