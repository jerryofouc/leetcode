package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/7/17.
 */
public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        if(num.length() == k){
            return "0";
        }
        for(int i=0;i<k;i++){
            char last = num.charAt(0);
            boolean isEnd = true;
            for(int j=1;j<num.length();j++){
                if(num.charAt(j)<last){
                    num = num.substring(0,j-1) + num.substring(j,num.length());
                    int p = 0;
                    while (p<num.length()&&num.charAt(p) == '0'){
                        p++;
                    }
                    num = num.substring(p,num.length());
                    if(num.length() <= k-i-1 || num.equals("0")){
                        return 0+"";
                    }
                    isEnd = false;
                    break;
                }else {
                    last = num.charAt(j);
                }
            }
            if(isEnd){
                num = num.substring(0,num.length()-1);
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("21",1));
    }


}
