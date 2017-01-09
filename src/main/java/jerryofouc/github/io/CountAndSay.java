package jerryofouc.github.io;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaojiez on 1/9/17.
 */
public class CountAndSay {
    public static String countAndSay(int n) {
        int count = 0;
        String ret = "1";
        Map<String,String> next = new HashMap<String, String>();
        next.put("1","11");
        next.put("2","12");
        next.put("11","21");
        for(int i=1;i<n;i++){
            String nextStr = "";
            char[] aa = ret.toCharArray();
            for(int j=0;j<aa.length;j++){
                if(j+1<aa.length && aa[j] == '1' && aa[j+1] == '1'){
                    nextStr = nextStr+"21";
                    j++;
                }else if(aa[j] == '1'){
                    nextStr = nextStr+"11";
                }else if(aa[j] == '2'){
                    nextStr = nextStr+"12";
                }
            }
            ret = nextStr;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}
