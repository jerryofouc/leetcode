package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaojiez on 3/12/17.
 */
public class KthSmallestLexicographicalOrder {
    public int findKthNumber(int n, int k) {
        List<Integer> result = lexicalOrder(n);
        return result.get(k-1);
    }

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for(int i=1;i<10;i++){
            if(i<=n){
                result.add(i);
                lexicalOrder(i,n,result);
            }

        }
        return result;
    }

    private static void lexicalOrder(int prefix, int n,List<Integer> result) {
        for(int i=0;i<10;i++){
            if(prefix*10+i<=n){
                result.add(prefix*10+i);
                lexicalOrder(prefix*10+i,n,result);
            }
        }
    }
}
