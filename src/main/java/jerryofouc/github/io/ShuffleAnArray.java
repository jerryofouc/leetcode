package jerryofouc.github.io;

import java.util.Random;

/**
 * Created by xiaojiez on 2/28/17.
 */
public class ShuffleAnArray {
    private int[] nums;
    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shuffledArray = new int[nums.length];
        System.arraycopy(nums,0,shuffledArray,0,shuffledArray.length);
        for(int i=0;i<shuffledArray.length;i++){
            int cur = i+new Random().nextInt(shuffledArray.length-i);
            int temp = shuffledArray[i];
            shuffledArray[i] = shuffledArray[cur];
            shuffledArray[cur] = temp;
        }
        return shuffledArray;
    }
}
