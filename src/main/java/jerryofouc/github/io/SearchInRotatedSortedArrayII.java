package jerryofouc.github.io;

/**
 * @author zhangxiaojie
 *         2014-11-15 00:04
 *         功能介绍:
 */
public class SearchInRotatedSortedArrayII {
    public static boolean search(int[] A, int target) {

        int left = 0;
        int right = A.length -1;
        while(left <= right){
            int mid = (left+right)/2;
            if(A[left] == target||A[mid] == target || A[right] == target){
                return true;
            }
            if(A[left] == A[right]||A[left] == A[mid]){
                left++;
            }else if(A[right] == A[mid]){
                right--;
            }else if(A[left] < A[mid] ){
                if(A[mid] < A[right]){
                    if(target<A[left] || target>A[right]){
                        return false;
                    }else {
                        if(target > A[mid]){
                            left = mid+1;
                            right --;
                        }else {
                            right = mid-1;
                            left++;
                        }
                    }
                }else {
                    if(target > A[left] && target<A[mid]){
                        left++;
                        right = mid-1;
                    }else {
                        left = mid+1;
                        right = right-1;
                    }
                }

            }else if(A[left] > A[mid]){
                if(target > A[left] || target<A[mid]) {
                    left++;
                    right = mid - 1;
                }else if(target>A[mid] && target<A[right]){
                    left = mid+1;
                    right--;
                }else{
                    return false;
                }
            }else {
                return false;
            }
        }
        return false;
    }

    public static void main(String args[]){
        int A[] = {5,1,3};
        System.out.println(search(A, 4));;
    }

}
