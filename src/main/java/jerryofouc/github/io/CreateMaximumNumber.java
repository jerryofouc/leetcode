package jerryofouc.github.io;

/**
 * Created by xiaojiez on 2/11/17.
 */
public class CreateMaximumNumber {


    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {

        int[] result = new int[k];
        for(int i=Math.max(k-nums2.length,0);i<=nums1.length&&i<=k;i++){
            int[] cur = merge(max(nums1,i),max(nums2,k-i));
            if(isGreater(cur,0,result,0)){
                result = cur;
            }
        }
        return result;

    }

    private static boolean isGreater(int[] n1,int s1, int[] n2,int s2) {
        int i,j;
        for(i=s1,j=s2;i<n1.length&&j<n2.length;i++,j++){
            if(n1[i]>n2[j]){
                return true;
            }else if(n1[i]<n2[j]){
                return false;
            }
        }
        if(i<n1.length){
            return true;
        }else {
            return false;
        }
    }

    private static int[] merge(int[] max, int[] max1) {
        int[] result = new int[max.length+max1.length];
        int j=0;
        int k=0;
        for(int i=0;i<result.length;i++){
            if(isGreater(max,j,max1,k)){
                result[i] = max[j++];
            }else {
                result[i] = max1[k++];
            }
        }
        return result;
    }

    private static int[] max(int[] nums, int k) {
        int[] result = new int[k];
        if(k == 0){
            return result;
        }
        int start =0;
        for(int i=0;i<k;i++){
            for(int j=9;j>=0;j--){
                boolean shouldBreak = false;
                for(int p =start;p<nums.length&&nums.length-p>=k-i;p++){
                    if(j == nums[p]){
                        result[i] = j;
                        start = p+1;
                        shouldBreak = true;
                        break;
                    }
                }
                if(shouldBreak){
                    break;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 9};
        int[] nums2 = new int[]{8, 9};
        int k = 3;
        long t1 = System.currentTimeMillis();
        maxNumber(nums1,nums2,k);
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }


}
