package jerryofouc.github.io;

/**
 * @author zhangxiaojie
 *         2014-11-23 12:58
 *         功能介绍:
 */
public class AddBinary {
    public static void main(String args[]){
        System.out.println(addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b) {
        char[] aa = a.toCharArray();
        reverse(aa);
        char[] bb = b.toCharArray();
        reverse(bb);
        String result = "";
        int carry = 0;
        int i = 0;
        for(;i<aa.length && i<bb.length;i++){
            int ai = aa[i] - '0';
            int bi = bb[i] - '0';
            int c = carry + ai + bi;
            result = c%2 + result;
            carry = c/2;
        }

        while(i<aa.length){
            int ai = aa[i] - '0';
            int c = carry + ai ;
            result = c%2 + result;
            carry = c/2;
            i++;
        }

        while(i<bb.length){
            int bi = bb[i] - '0';
            int c = carry + bi ;
            result = c%2 + result;
            carry = c/2;
            i++;
        }

        if(carry == 1){
            result = carry+result;
        }

        return result;
    }
    private static void reverse(char[] a){
        int begin = 0;
        int end = a.length -1;
        while(begin < end){
            char tmp = a[begin];
            a[begin] = a[end];
            a[end] = tmp;
            begin++;
            end--;
        }
    }
}
