package jerryofouc.github.io;

/**
 * @author zhangxiaojie
 *         2014-11-30 23:27
 *         功能介绍:
 */
public class ReverseInteger {
    public static void main(String args[]){
        System.out.println(reverse(-2147483648));
        int a = 1534236469;
        int b= 1534236469;
    }
    public static int reverse(int x) {
        String a = "" + Math.abs((long)x);
        char[] ac = a.toCharArray();
        int start = 0,end = ac.length-1;
        while(start < end){
            char tmp = ac[start];
            ac[start++] = ac[end];
            ac[end--] = tmp;
        }
        long l  ;
        if(x >0 ){
             l=  Long.parseLong(new String(ac));
        }else {
            l =  -Long.parseLong(new String(ac));
        }
        if(l > Integer.MAX_VALUE || l< Integer.MIN_VALUE){
            return 0;
        }else {
            return (int)l;
        }

    }
}
