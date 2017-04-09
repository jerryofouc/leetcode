package jerryofouc.github.io;

import java.util.Arrays;

/**
 * Created by xiaojiez on 4/9/17.
 */
public class NextGreaterElementIII {
    public static int nextGreaterElement(int n) {
        String a = n+"";
        if(a.length() == 1){
            return -1;
        }
        String r = new StringBuilder(a).reverse().toString();
        int k = -1;
        for(int i=1;i<r.length();i++){
            if(r.charAt(i)<r.charAt(i-1)){
                k = i;
                break;
            }
        }

        StringBuilder sb = new StringBuilder(r);
        if(k != -1){
            char[] sbb = sb.toString().toCharArray();
            for(int i=0;i<k;i++){
                if(sbb[i]>sbb[k]){
                    char temp = sbb[i];
                    sbb[i] = sbb[k];
                    sbb[k] = temp;
                    break;
                }
            }
            sb = new StringBuilder(new String(sbb));
            if(k-1>0){
                char[] aa = new StringBuilder(sb.substring(0,k)).toString().toCharArray();
                Arrays.sort(aa);
                sb = sb.replace(0,k,new StringBuilder(new String(aa)).reverse().toString());
            }
        }else {
            return -1;
        }
        long ret = Long.parseLong(sb.reverse().toString());
        if(ret<=Integer.MAX_VALUE){
            return (int)ret;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(nextGreaterElement(12443322));
    }
}
