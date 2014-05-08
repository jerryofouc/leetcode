package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 5/8/14
 * Time: 13:55
 * To change this template use File | Settings | File Templates.
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int c[] = new int[m+n];
        int mi = 0,ni=0,ci = 0;
        for(; mi <m && ni <n;ci++) {
            if(A[mi] < B[ni]){
                c[ci] = A[mi];
                mi++;
            }else {
                c[ci] = B[ni];
                ni++;
            }
        }
        while(mi <m ){
            c[ci++] = A[mi++];
        }
        while(ni < n ){
            c[ci++] = B[ni++];
        }
        for(int i=0;i<m+n;i++){
            A[i] = c[i];
        }
    }
}
