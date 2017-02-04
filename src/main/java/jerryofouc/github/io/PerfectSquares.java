package jerryofouc.github.io;

/**
 * Created by xiaojiez on 2/1/17.
 */
public class PerfectSquares {
    public static int numSquares(int n) {
        int a[] = new int[n+1];
        a[0] = 0;
        for(int i=1;i<=n;i++){
            int min = Integer.MAX_VALUE;
            int j = 1;
            while (true){
                if(i-j*j>=0){
                    if(min > a[i-j*j]+1){
                        min = a[i-j*j]+1;
                    }
                    j++;
                }else {
                    break;
                }
            }
            a[i] = min;
        }
        return a[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}
