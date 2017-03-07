package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xiaojiez on 3/7/17.
 */
public class BinaryWatch {
    public static List<String> readBinaryWatch(int num) {
        Set<String> result = new HashSet<>();
        tranverse(9,num,0,result);
        return new ArrayList<>(result);
    }

    private static void tranverse(int k, int num, int target, Set<String> result) {
        if(num == 0){
            target = target|(((1<<num)-1));
            int a = (target>>6);
            int b = (target&((1<<6)-1));
            if(a<12&&b<60){
                String r = a+":" +(b>9?b:"0"+b);
                result.add(r);
            }
        }else {
            if(k+1<num){
                return;
            }else {
                tranverse(k-1,num,target,result);
                tranverse(k-1,num-1,target|(1<<k),result);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(readBinaryWatch(1));

    }
}
