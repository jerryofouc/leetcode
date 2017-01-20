package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaojiez on 1/19/17.
 */
public class RepeatedDNASequences {
    public static List<String>  findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        Map<String,Integer> map = new HashMap<String, Integer>();
        for(int i=0;i+10<=s.length();i++){
            String sub = s.substring(i,i+10);
            Integer num = map.get(sub);
            if(num == null){
                map.put(sub,1);
            }else {
                if(1==num){
                    result.add(sub);
                }
                map.put(sub,num+1);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));
    }
}
