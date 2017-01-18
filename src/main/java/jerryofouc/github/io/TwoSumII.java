package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/18/17.
 */
public class TwoSumII {
    public static int[] twoSum(int[] numbers, int target) {
        int begin = 0,end = numbers.length-1;
        while (begin<end){
            if(numbers[begin] + numbers[end] == target){
                return new int[]{begin+1,end+1};
            }else if(numbers[begin] + numbers[end] > target){
                end --;
            }else {
                begin++;
            }
        }
        return null;
    }
}
