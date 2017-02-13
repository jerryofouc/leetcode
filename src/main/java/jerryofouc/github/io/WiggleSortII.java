package jerryofouc.github.io;

/**
 * Created by xiaojiez on 2/13/17.
 */
public class WiggleSortII {
    public static void wiggleSort(int[] nums) {
        if(nums==null || nums.length <= 1){
            return;
        }
        int k = 0;
        for(int i=0;i<nums.length-1;i++){
            int next = nums[i+1];
            boolean isChanged = false;
            if(nums[i] == next){
                for(int j=0;j<i;j+=2){
                    if(nums[j]!=next && (j-1<0||nums[j-1]>next) &&  (j+1>=nums.length||nums[j+1]>next)){
                        int temp = nums[i+1];
                        nums[i+1] = nums[j];
                        nums[j] = temp;
                        isChanged = true;
                        break;
                    }
                }

                if(!isChanged){
                    for(int j=1;j<i;j+=2){
                        if(nums[j]!=next &&  (j-1<0||nums[j-1]<next) &&  (j+1>=nums.length||nums[j+1]<next)){
                            int temp = nums[i+1];
                            nums[i+1] = nums[j];
                            nums[j] = temp;
                            break;
                        }
                    }
                }

                if(!isChanged){
                    for(int j=i+2;j<nums.length;j++){
                        if(nums[j]!=next){
                            int temp = nums[i+1];
                            nums[i+1] = nums[j];
                            nums[j] = temp;
                            break;
                        }
                    }
                }
            }





            if(i+1<nums.length){
                if(k == 0&&nums[i]>nums[i+1]){
                     int temp = nums[i];
                     nums[i] = nums[i+1];
                     nums[i+1] = temp;
                }else if(k == 1&&nums[i]<nums[i+1]){
                    int temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                }
            }
            k=1-k;
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,5,6};
        wiggleSort(nums);
        System.out.println("112");
    }
}
