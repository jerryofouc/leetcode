package jerryofouc.github.io;

/**
 * Created by xiaojiez on 4/16/17.
 */
public class SplitAssembledStrings {
    public static String splitLoopedString(String[] strs) {
        StringBuilder total = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            String reverse = new StringBuilder(strs[i]).reverse().toString();
            if (strs[i].compareTo(reverse) < 0) {
                strs[i] = reverse;
            }
            total.append(strs[i]);
        }

        int start = 0;
        String max = total.toString();
        for (int i = 0; i < strs.length; i++) {
            StringBuilder cur = new StringBuilder(strs[i]);
            for(int j=0;j<strs[i].length();j++){
                StringBuilder curTotal =
                        new StringBuilder(cur.substring(j))
                                .append(new StringBuilder(total.substring(start+cur.length())))
                                .append(total.substring(0,start))
                                .append(cur.substring(0,j));
                if(max.compareTo(curTotal.toString())<0){
                    max = curTotal.toString();
                }
            }
            StringBuilder reverse = new StringBuilder(strs[i]).reverse();
            for(int j=0;j<strs[i].length();j++){
                StringBuilder curTotal =
                        new StringBuilder(reverse.substring(j))
                                .append(new StringBuilder(total.substring(start+reverse.length())))
                                .append(total.substring(0,start))
                                .append(reverse.substring(0,j));
                if(max.compareTo(curTotal.toString())<0){
                    max = curTotal.toString();
                }
            }
            start += cur.length();
        }
        return max;
    }

    public static void main(String[] args) {
        String[] strs = {"awef","eawf","zdaeff","awefzewaf","awefzewaf"};
        System.out.println(splitLoopedString(strs));
    }
}
