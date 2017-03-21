package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/20/17.
 */
public class ValidateIPAddress {
    public static String validIPAddress(String IP) {
        final String neither = "Neither";
        if(IP.contains(".")){
            if(IP.endsWith(".") || IP.startsWith(".")){
                return neither;
            }
            String[] a = IP.split("\\.");
            if(a.length != 4){
                return neither;
            }
            for(String i : a){
                int k;
                try {
                    k = Integer.parseInt(i);
                }catch (RuntimeException e){
                    return neither;
                }
                if((i.length() !=1&&i.startsWith("0")) || i.startsWith("-")){
                    return neither;
                }
                if(k>255||k<0){
                    return neither;
                }
            }
            return "IPv4";

        }else if(IP.contains(":")){
            if(IP.endsWith(":") || IP.startsWith(":")){
                return neither;
            }
            String[] a = IP.split(":");
            if(a.length != 8){
                return neither;
            }
            for(String i : a){
                if(i.length()>4 || i.length() == 0){
                    return neither;
                }
                for(int j = 0;j<i.length();j++){
                    char aa = i.charAt(j);
                    if(!(aa>='a'&&aa<='f')&&!(aa>='A'&&aa<='F')&&!(aa>='0'&&aa<='9')){
                        return neither;
                    }
                }
            }
            return "IPv6";

        }else {
            return "Neither";
        }
    }

    public static void main(String[] args) {
//        System.out.println(validIPAddress("172.16.254.1"));
//        System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
//        System.out.println(validIPAddress("256.256.256.256"));
       System.out.println(validIPAddress("192.0.0.1"));
    }

}
