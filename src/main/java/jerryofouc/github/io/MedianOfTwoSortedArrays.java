package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 5/21/14
 * Time: 15:00
 * To change this template use File | Settings | File Templates.
 */
public class MedianOfTwoSortedArrays {

    public static void main(String args[]){
        int A[] = {4};
        int B[] = {1,2,3};
        System.out.println(findMedianSortedArrays(A, B));
    }

    public static double findMedianSortedArrays(int A[], int B[]) {

        if (A.length > B.length) {
            return findMedianSortedArrays(B, A);
        }

        if(A.length == 0){
            if(B.length %2 == 0){
                return (B[B.length/2] + B[B.length/2 - 1])/2.0;
            }else {
                return B[B.length/2];
            }
        }

        int m = A.length;
        int n= B.length;

        int begin = 0;
        int end = m-1;
        int j = 0;
        int i = (begin + end)/2;
        while(begin <= end){
            i = (begin + end)/2;
            j = (m+n+1)/2 -i - 1;

            if( A[i] > B[j]){
                end = i-1;
            }else if(i < m-1 &&  j >0 && A[i+1] < B[j-1] ){
                begin = i+1;
            }else {
                if(j>0 && i<m-1 && A[i] <= B[j] && A[i+1]>=B[j-1] ){
                    if((m+n) % 2 == 0){
                        return ((Math.max(A[i],B[j-1])+Math.min(A[i+1],B[j]))/2.0);
                    }else {
                        return Math.max(A[i],B[j-1]);
                    }
                }else if(i == m-1){
                    if((m+n) % 2 == 0){
                        if(j>0){
                            return ((Math.max(A[i],B[j-1])+B[j])/2.0);
                        }else {
                            return (A[i]+B[j])/2.0;
                        }
                    }else {
                        return Math.max(A[i],B[j-1]);
                    }
                }else if(j == 0){
                    if((m+n) % 2 == 0){
                        return (A[m-1]+B[0])/2.0;
                    }else {
                        return B[0];
                    }
                }
            }
        }

        if(end < 0){
            if((m+n) % 2 == 0){
                if(j == n-1){
                    return (B[j] + A[i])/2.0;
                }else {
                    return (B[j] + Math.min(B[j+1],A[i]))/2.0;
                }

            }else {
                return B[(m+n+1)/2-1];
            }
        }



        return -1;


    }




}
