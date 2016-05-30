package jerryofouc.github.io;

/**
 * @author zhangxiaojie
 *         2014-10-24 09:45
 *         功能介绍:
 */
public class ZigZagConversion {

    public static void main(String args[]){
        System.out.println(convert("A",1));
    }
    public static String convert(String s, int nRows) {
        if(nRows == 1){
            return s;
        }
        char[] sc = s.toCharArray();
        String result = "";
        int interval = (nRows-1)*2 - 1;
        for(int i=0;i<nRows;i++){
            int start = i;
            if(i == 0 || i == nRows-1){
                while(start < s.length()){
                    result += sc[start];
                    start += interval+1;
                }
            }else {
                int k = 0;
                while(start < s.length()){
                    result += sc[start];
                    if(k++ %2 == 0){
                        start += interval - i*2+1;
                    }else {
                        start += interval - (nRows - i-1)*2 + 1;
                    }
                }
            }
        }
        return result;
    }
}
