package jerryofouc.github.io;


/**
 * Created by xiaojiez on 3/12/17.
 */
public class KthSmallestLexicographicalOrder {
    public static int findKthNumber(int n, int k) {
        int cur = 1;
        k--;
        while (k > 0){
            int steps = getSteps(cur,cur+1,n);
            if(k>=steps){
                cur++;
                k = k-steps;
            }else {
                k--;
                cur = cur*10;
            }
        }
        return cur;
    }

    private static int getSteps(long n1, long n2, int n) {
        int steps = 0;
        while (n1<=n){
            steps += Math.min(n+1,n2)-n1;
            n1*=10;
            n2*=10;
        }
        return steps;
    }


    public static void main(String[] args) {
        System.out.println(findKthNumber(13,1));
    }
}
