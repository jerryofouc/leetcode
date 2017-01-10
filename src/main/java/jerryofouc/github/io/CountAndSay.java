package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/9/17.
 */
public class CountAndSay {
    public static String countAndSay(int n) {
        int count = 0;
        String ret = "1";


        for(int i=1;i<n;i++){
            String nextStr = "";
            char[] aa = ret.toCharArray();
            for(int j=0;j<aa.length;){
                int k = j;
                char t = aa[k];
                while (k+1<aa.length&&aa[k] == aa[k+1]){
                    k++;
                }
                nextStr = nextStr+(k-j+1);
                nextStr = nextStr+t;
                j = k+1;
            }
            ret = nextStr;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(6));
    }
}
