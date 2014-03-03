package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 2/27/14
 * Time: 22:51
 * To change this template use File | Settings | File Templates.
 */
public class PalindromePartitioning {
    public static ArrayList<ArrayList<String>> partition(String s){
        HashMap<String,Boolean> palindromeTable = new HashMap<String,Boolean>();
        HashMap<String,ArrayList<ArrayList<String>>> resultTable = new HashMap<String, ArrayList<ArrayList<String>>>();
        for(int i=0;i<s.length();i++){
            ArrayList<ArrayList<String>> temp = new ArrayList<ArrayList<String>>();
            ArrayList<String> t = new ArrayList<String>();
            t.add(s.charAt(i)+"");
            temp.add(t);
            resultTable.put(s.charAt(i)+"",temp);
            palindromeTable.put(s.charAt(i)+"",true);
        }

        for(int len = 1;len<s.length();len++){
            for(int start=0;start<s.length()-len;start++){
                if(resultTable.get(s.substring(start,start+len+1))!=null){
                    continue;
                }
                ArrayList<ArrayList<String>> t = new ArrayList<ArrayList<String>>();
                for(int k=start;k<start+len;k++){
                    if(palindromeTable.get(s.substring(start,k+1))!=null){
                        t.addAll(join(s.substring(start, k + 1), resultTable.get(s.substring(k + 1, start + len + 1))));
                    }
                }
                if (palindrome1(start, start + len, s, palindromeTable)) {
                    ArrayList<String> t1 = new ArrayList<String>();
                    t1.add(s.substring(start, start + len + 1));
                    t.add(t1);
                }
                resultTable.put(s.substring(start,start+len+1),t);
            }
        }

        return resultTable.get(s);
    }

    private static boolean palindrome1(int start, int end, String s, HashMap<String, Boolean> palindromeTable) {
        if(start == end){
            return true;
        }
        boolean retValue = false;
        if(end - start==1){
            retValue = s.charAt(start) == s.charAt(end);
        }else{
            retValue =  s.charAt(start)==s.charAt(end)&&(palindromeTable.get(s.substring(start+1,end))!=null);
        }
        if(retValue){
            palindromeTable.put(s.substring(start,end+1),true);
        }
        return retValue;
    }

    private static ArrayList<ArrayList<String>> join(String a, ArrayList<ArrayList<String>> a2) {
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        for (ArrayList<String> j : a2) {
            ArrayList<String> aa = new ArrayList<String>();
            aa.add(a);
            aa.addAll(j);
            ret.add(aa);
        }
        return ret;
    }





    public static void main(String args[]) {
        System.out.println(partition("ltsqjodzeriqdtyewsrpfscozbyrpidadvsmlylqrviuqiynbscgmhulkvdzdicgdwvquigoepiwxjlydogpxdahyfhdnljshgjeprsvgctgnfgqtnfsqizonirdtcvblehcwbzedsmrxtjsipkyxk"));
    }
}
