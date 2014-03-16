package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 3/11/14
 * Time: 21:19
 * To change this template use File | Settings | File Templates.
 */
public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        if(s == null ){
            return true;
        }
        byte[] bytes = s.getBytes();
        int start = 0;
        int end = bytes.length-1;
        while(start < end ){
            if(!isAphabetNumric(bytes[start])){
                start++;
                continue;
            }
            if(!isAphabetNumric(bytes[end])){
                end--;
                continue;
            }
            if(!isEqual(bytes[start],bytes[end])){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    private static boolean isAlphabet(byte b){
        if(b>='a' && b<='z' || b>='A' && b<='Z'){
            return true;
        }
        return false;
    }

    private static boolean isEqual(byte aByte, byte aByte1) {
        if(aByte == aByte1){
            return true;
        }else if(isAlphabet(aByte)&&isAlphabet(aByte1)){
            return aByte+32==aByte1||aByte-32==aByte1;
        }
        return false;
    }


    private static boolean isAphabetNumric(byte aByte) {
        if(aByte >= 'a' && aByte<='z' || aByte>='A' && aByte<='Z' || aByte>='0' && aByte<='9'){
            return true;
        }
        return false;
    }

    public static void main(String args[]){
        System.out.println(isPalindrome("ab"));;
    }
}
