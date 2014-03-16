package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 3/16/14
 * Time: 18:17
 * To change this template use File | Settings | File Templates.
 */
public class ReverseWordsString {
    public static String reverseWords(String s) {
        s = s.trim();
        if (s == null ||s.length()==0|| s.length() == 1) {
            return s;
        }
        byte[] bytes = s.getBytes();
        byte[]  newBytes = new byte[bytes.length];
        int oneSpace = -1;
        int j=0;
        for(int i=0;i<bytes.length;i++){
           if(bytes[i] == ' '){
               if(oneSpace == -1){
                   newBytes[j++] = ' ';
                   oneSpace = 1;
               }
           }else{
               newBytes[j++] = bytes[i];
               oneSpace = -1;
           }
        }

        bytes = new String(newBytes).trim().getBytes();
        reverse(bytes, 0,bytes.length - 1);
        int wordStart = -1;
        int wordEnd = -1;
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] != ' ') {
                if (wordStart == -1) {
                    wordStart = i;
                }
            } else {
                if (wordStart != -1) {
                    wordEnd = i-1;
                    reverse(bytes, wordStart, wordEnd);
                    wordStart = -1;
                }
            }
        }

        if(bytes[bytes.length-1] != ' '){
            reverse(bytes,wordStart,bytes.length-1);
        }

        return new String(bytes);
    }

    static void  reverse(byte[] bytes, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            byte temp = bytes[i];
            bytes[i] = bytes[j];
            bytes[j] = temp;
        }
    }

    public static void main(String args[]){
        System.out.println(reverseWords("   a   b "));
    }
}
