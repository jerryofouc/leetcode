package jerryofouc.github.io;

/**
 * Created by xiaojiez on 2/1/17.
 */

 class VersionControl{
    boolean isBadVersion(int version){
        return false;
    }
}

public class FirstBadVersion extends VersionControl{
    public int firstBadVersion(int n) {
        int start = 0;
        int end = n;
        while (start<=end){
            int m = start + (end-start)/2;
            if(isBadVersion((int)m)){
                end = m-1;
            }else {
                start = m+1;
            }
        }
        return start;
    }

}
