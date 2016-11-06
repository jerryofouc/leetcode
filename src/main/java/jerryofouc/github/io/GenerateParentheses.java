package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xiaojiezhang on 11/6/16.
 */
public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        Set<String> a0 = new HashSet<String>();
        a0.add("");
        Set<String> a1 = new HashSet<String>();
        a1.add("()");
        if(n == 0){
            return new ArrayList<String>(a0);
        }
        if(n == 1){
            return new ArrayList<String>(a1);
        }

        List<Set<String>> aa = new ArrayList<Set<String>>();
        aa.add(a0);
        aa.add(a1);


        for(int i=2;i<=n;i++){
            Set<String> ai = new HashSet<String>();
            for(int j = 0;j<=i-1;j++){
                int k = (i-1)-j;
                Set<String> aj = aa.get(j);
                Set<String> ak = aa.get(k);
                Set<String> pre = new HashSet<String>();
                for(String a : aj){
                    pre.add("(" + a +")");
                }
                for(String a : pre){
                    for(String b : ak){
                        ai.add(a + b);
                    }
                }
            }
            aa.add(ai);

        }
        return new ArrayList<String>(aa.get(n));
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(4));
    }


}
