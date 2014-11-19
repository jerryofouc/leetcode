package jerryofouc.github.io;

import java.util.ArrayList;

/**
 * @author zhangxiaojie
 *         2014-11-19 17:43
 *         功能介绍:
 */
public class SortColors {
    public static void main(String args[]){
        int[] A = {2,0,2};
        sortColors(A);
    }
    public static void sortColors(int[] A) {
        int zeorBegin = 0;
        int threeEnd = A.length;
        for(int i=0;i<A.length&&i<threeEnd;i++){
            if(A[i] == 0){
                if(i != zeorBegin){
                    A[i] = 1;
                }
                A[zeorBegin++] = 0;


            }else if(A[i] == 2){
                threeEnd--;
                if(A[threeEnd] == 0){
                    A[i--] = 0;
                    A[threeEnd] = 2;
                }else if(A[threeEnd] == 2){
                    i--;
                }else {
                    if(threeEnd != i){
                        A[threeEnd] = 2;
                        A[i] = 1;
                    }
                }
            }
        }
    }
}
