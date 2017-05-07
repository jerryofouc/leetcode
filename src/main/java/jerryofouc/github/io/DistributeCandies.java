package jerryofouc.github.io;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaojiez on 5/7/17.
 */
public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<candies.length;i++){
            if(set.size()<candies.length/2){
                set.add(candies[i]);
            }else {
                return candies.length/2;
            }
        }
        return set.size();
    }
}
