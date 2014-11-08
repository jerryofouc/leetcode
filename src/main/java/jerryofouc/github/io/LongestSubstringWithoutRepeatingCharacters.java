package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 6/18/14
 * Time: 14:54
 * To change this template use File | Settings | File Templates.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }

        int max = 0;
        int curLen = 0;
        byte[] sb = s.getBytes();
        int table[] = new int[129];

        for(int i =0 ;i<sb.length;i++){
            if(table[sb[i]] != 0){
                int curIndex = table[sb[i]];
                for(int k=0;k<129;k++){
                    if(table[k] != 0 && table[k] < curIndex){
                        table[k] = 0;
                    }
                }
                curLen = (i - curIndex)+1;
                table[sb[i]] = i+1;
            }else {
                table[sb[i]] = i+1;
                curLen++;
                if(max < curLen){
                    max = curLen;
                }
            }
        }

        return max;
    }

    public static void main(String args[]){
        System.out.println(lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"));
    }
}
