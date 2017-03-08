package jerryofouc.github.io;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaojiez on 3/8/17.
 */
public class ConvertANumberToHexadecimal {
    public static String toHex(int num) {
        Map<Integer,Character> map = new HashMap<>();
        map.put(10,'a');
        map.put(11,'b');
        map.put(12,'c');
        map.put(13,'d');
        map.put(14,'e');
        map.put(15,'f');
        String result = "";
        for(int i=0;i<8;i++){
            int a = (num&15);
            result = (map.get(a)==null?a+"":map.get(a))+result;

            num = (num>>4);
        }
        int i;
        for( i=0;i<result.length();i++){
            if(result.charAt(i) != '0'){
                break;
            }
        }
        if(i == result.length()){
            return 0+"";
        }else {
            return result.substring(i);
        }

    }

    public static void main(String[] args) {
        System.out.println(toHex(26));
    }
}
