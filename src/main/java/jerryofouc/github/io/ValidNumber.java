package jerryofouc.github.io;

/**
 * @author zhangxiaojie
 *         2014-11-23 12:11
 *         功能介绍:
 */
public class ValidNumber {

    public static void main(String args[]){
       // System.out.println(".1".split("\\.").length);
        System.out.println(isNumber("+.8"));
    }
    public static boolean isNumber(String s) {
        s = s.trim();
        if(s.equals("") ){
            return false;
        }

        if(isInteger(s)){
            return true;
        }

        if(isFloat(s)){
            return true;
        }
        return false;
    }

    private static boolean isFloat(String s) {
        for(int i=0;i<s.length();i++){
            char sc = s.charAt(i);
            if(  (sc<'0' || sc>'9') && sc != 'e' &&sc != '-' && sc != '.'&& sc != '+' ){
                return false;
            }
        }

        if(s.charAt(0) == '-' || s.charAt(0) == '+'){
            s = s.substring(1);
        }

        if(s.charAt(0) == '-' || s.charAt(0) == '+'){
            return false;
        }

        if(s.contains(".")){
            if(s.length() == 1){
                return false;
            }
            if(s.endsWith(".")){
                s += "0";
            }
            String ss[] = s.split("\\.");
            if(ss.length != 2){
                return false;
            }

            if(ss[0].equals("") ){
                ss[0] = "0";
            }




        }




        try{
            Float.parseFloat(s.trim());
        }catch (NumberFormatException e){
            return false;
        }
        return true;

    }

    private static boolean isInteger(String s) {
        try{
            Integer.parseInt(s) ;
        }catch (NumberFormatException e){
            return false;
        }

        return true;
    }
}
