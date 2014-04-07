package jerryofouc.github.io;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 4/7/14
 * Time: 17:17
 * To change this template use File | Settings | File Templates.
 */
public class RestoreIPAddresses {
    public static ArrayList<String> restoreIpAddresses(String s) {
        if(s.length()<4||s.length()>12){
            return new ArrayList<String>();
        }
        ArrayList<String> ret = new ArrayList<String>();
        ArrayList<String> left ;
        ArrayList<String> right;
        for(int i=1;i<=s.length()-3;i++){
            left = findTwo(s,0,i);
            right = findTwo(s,i+1,s.length()-1);
            if(!left.isEmpty() &&!right.isEmpty()){
                for(String l : left){
                    for(String r : right){
                        ret.add(l + "." + r);
                    }
                }
            }
        }
        return ret;
    }

    private static ArrayList<String> findTwo(String schars, int begin, int end) {
        ArrayList<String> ret = new ArrayList<String>();
        for(int i=begin;i<=end-1;i++){
            String first =  schars.substring(begin,i+1);
            String second = schars.substring(i+1,end+1);
            if((first.charAt(0) != '0'|| (first.length() == 1 && first.charAt(0) == '0')) && Long.parseLong(first) < 256
            && (second.charAt(0) != '0'||(second.length() == 1 && second.charAt(0) == '0')) &&Long.parseLong(second)<256){
                ret.add(first + "." + second);
            }
        }
        return ret;
    }

    public static void main(String args[]){
        System.out.println(restoreIpAddresses("0000"));
    }


}
