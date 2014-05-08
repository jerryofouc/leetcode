package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 4/21/14
 * Time: 9:28
 * To change this template use File | Settings | File Templates.
 */
public class DecodeWays {
    public static int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        byte[] bytes = s.getBytes();
        if(bytes[0] == '0'){
            return 0;
        }
        int mem[] = new int[2];
        mem[0] = 1;
        mem[1] = 1;
        if(s.length() == 1){
            return 1;
        }
        for(int i=1;i<s.length();i++){
            int value  = 0;
            if(isChar(bytes[i-1]-'0',bytes[i]-'0')){
                value += mem[0];
            }
            if(bytes[i]>='1' && bytes[i]<='9'){
                value += mem[1];
            }
            mem[0] = mem[1];
            mem[1] = value;
        }
        return mem[1];
    }

    private static boolean isChar(int num1,int num2){
        if(num1 == 0){
            return false;
        }
        int num = num1*10 + num2;
        return  num>=1&&num<=26;
    }

    public static void main(String args[]){
        System.out.println(numDecodings("12"));
    }
}
