package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/4/17.
 */
public class RotateFunction {
    public static int maxRotateFunction(int[] A) {
        int sum = 0;
        for(int i=0;i<A.length;i++){
            sum += A[i];
        }
        int first = 0;
        for(int i=0;i<A.length;i++){
            first += i*A[i];
        }

        int cur = first;
        int max = cur;
        for(int i=1;i<A.length;i++){
            cur = cur + sum - A.length*A[A.length-i];
            if(cur > max){
                max = cur;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4, 3, 2, 6};
        System.out.println(maxRotateFunction(a));
    }


}
