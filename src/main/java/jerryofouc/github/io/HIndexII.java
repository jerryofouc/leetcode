package jerryofouc.github.io;

/**
 * Created by xiaojiez on 2/1/17.
 */
public class HIndexII {
    public int hIndex(int[] citations) {
        int[] rr = new int[citations.length];
        for(int j=0;j<citations.length;j++){
            rr[j] = citations[citations.length-j-1];
        }

        int i=0;
        for(;i<rr.length;i++){
            if(rr[i]<i+1){
                return i;
            }
            if(rr[i] == i+1){
                return i+1;
            }
        }
        return i;

    }
}
