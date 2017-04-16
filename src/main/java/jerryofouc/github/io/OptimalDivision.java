package jerryofouc.github.io;

/**
 * Created by xiaojiez on 4/16/17.
 */
public class OptimalDivision {
    static class Pair{
        double minValue;
        String minResult;
        double maxValue;
        String maxResult;

        public Pair(double minValue, String minResult, double maxValue, String maxResult) {
            this.minValue = minValue;
            this.minResult = minResult;
            this.maxValue = maxValue;
            this.maxResult = maxResult;
        }

        public Pair() {
        }
    }
    public static String optimalDivision(int[] nums) {
        double[] a = new double[nums.length];
        for(int i=0;i<nums.length;i++){
            a[i] = nums[i];
        }
        Pair[][] result = new Pair[nums.length][nums.length+1];
        for(int i=0;i<a.length;i++){
            result[i][1] = new Pair(a[i],Integer.toString(nums[i]),a[i],Integer.toString(nums[i]));
        }
        for(int l=2;l<nums.length+1;l++){
            for(int i=0;i+l<nums.length+1;i++){
                int maxJ = i+1;
                int minJ = i+1;
                double max = result[i][1].maxValue/result[i+1][l-1].minValue;
                double min = result[i][1].minValue/result[i+1][l-1].maxValue;
                for(int j=i+2;j<i+l;j++){
                    double curMax = result[i][j-i].maxValue/result[j][l-(j-i)].minValue;
                    if(max<curMax){
                        max = curMax;
                        maxJ = j;
                    }
                    double curMin = result[i][j-i].minValue/result[j][l-(j-i)].maxValue;
                    if(min>curMin){
                        min = curMin;
                        minJ = j;
                    }
                }
                result[i][l] = new Pair();
                result[i][l].maxValue = max;
                if(maxJ<i+l-1){
                    result[i][l].maxResult = result[i][maxJ-i].maxResult +"/" + "(" +result[maxJ][l-(maxJ-i)].minResult+")";
                }else {
                    result[i][l].maxResult = result[i][maxJ-i].maxResult +"/"  +result[maxJ][l-(maxJ-i)].minResult;
                }
                result[i][l].minValue = min;
                if(minJ<i+l-1){
                    result[i][l].minResult = result[i][minJ-i].minResult +"/" + "(" +result[minJ][l-(minJ-i)].maxResult+")";
                }else {
                    result[i][l].minResult = result[i][minJ-i].minResult +"/"  +result[minJ][l-(minJ-i)].maxResult;
                }
            }
        }
        return result[0][nums.length].maxResult;
    }

    public static void main(String[] args) {
        int nums[] = {1000,100,10,2};
        System.out.println(optimalDivision(nums));
    }
}
