package jerryofouc.github.io;

/**
 * Created by xiaojiez on 2/11/17.
 */
public class RemoveDuplicateLetters {
    public static String removeDuplicateLetters(String s) {
        int[] idx = new int[26];
        for(int i=0;i<s.length();i++){
            idx[s.charAt(i)-'a']++;
        }
        int pos = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) < s.charAt(pos) ){
                pos = i;
            }
            if((--idx[s.charAt(i)-'a'])==0){
                break;
            }
        }
        if(s.length() ==0){
            return "";
        }else {
            return s.charAt(pos) + removeDuplicateLetters(s.substring(pos+1).replace(s.charAt(pos)+"",""));
        }
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }
}
