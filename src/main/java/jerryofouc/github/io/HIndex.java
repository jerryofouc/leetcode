package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xiaojiez on 2/1/17.
 */
public class HIndex {
    public static int hIndex(int[] citations) {
        if(citations == null || citations.length ==0){
            return 0;
        }

        List<Integer> cc = new ArrayList<>();
        for(int j=0;j<citations.length;j++){
            cc.add(citations[j]);
        }
        Collections.sort(cc, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1>o2?-1:(o1<o2?1:0);
            }
        });
        for(int j=0;j<citations.length;j++){
            citations[j] = cc.get(j);
        }

        int i=0;
        for(;i<citations.length;i++){
            if(citations[i]<i+1){
                return i;
            }
            if(citations[i] == i+1){
                return i+1;
            }
        }
        return i;

    }

    public static void main(String[] args) {
        int[] citations = new int[]{0};
        System.out.println(hIndex(citations));
    }
}
