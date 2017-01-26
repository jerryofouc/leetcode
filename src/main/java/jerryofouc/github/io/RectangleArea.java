package jerryofouc.github.io;

import java.util.Arrays;

/**
 * Created by xiaojiez on 1/26/17.
 */
public class RectangleArea {
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int inner = 0;
        if(D<F||H<B||A>G|E>C){
             inner = 0;
        }else{
            int[] a = new int[]{A,C,E,G};
            Arrays.sort(a);
            int[] b = new int[]{B,D,F,H};
            Arrays.sort(b);
            inner = (a[2]-a[1])*(b[2]-b[1]);
        }



        return Math.abs(G-E)*Math.abs(F-H)+ Math.abs(C-A)*Math.abs(B-D) -inner;

    }

    public static void main(String[] args) {
        System.out.println(computeArea(
                0,
                0,
                0,
                0,
                        -1,
                        -1,
                1,
                1
        ));
    }
}
