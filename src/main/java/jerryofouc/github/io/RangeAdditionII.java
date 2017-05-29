package jerryofouc.github.io;

/**
 * Created by xiaojiez on 5/28/17.
 */
public class RangeAdditionII {
    public int maxCount(int m, int n, int[][] ops) {
        if(ops.length == 0){
            return m*n;
        }
        int minM = Integer.MAX_VALUE;
        int minN = Integer.MAX_VALUE;
        for(int i=0;i<ops.length;i++){
            minM = Math.min(ops[i][0],minM);
            minN = Math.min(ops[i][1],minN);
        }
        return minM*minN;
    }
}
