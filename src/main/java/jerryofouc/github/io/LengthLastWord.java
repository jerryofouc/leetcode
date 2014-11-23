package jerryofouc.github.io;

/**
 * @author zhangxiaojie
 *         2014-11-23 22:54
 *         功能介绍:
 */
public class LengthLastWord {
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int begin = -1;
        int end = -1;
        for(int i=chars.length-1;i>=0;i--){
            if(chars[i] != ' ' ){
                if(end == -1){
                    end = i;
                }
                begin = i;
            }else {
                if(end != -1){
                    break;
                }
            }
        }

        if(end == -1){
            return 0;
        }

        return end-begin+1;
    }
}
