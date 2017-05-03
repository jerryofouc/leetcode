package jerryofouc.github.io;

/**
 * Created by xiaojiez on 4/25/17.
 */
public class FindtheClosestPalindrome {
    public static String nearestPalindromic(String n) {
        long a = 1;
        for(int i=0;i<n.length()/2;i++){
            a *= 10;
        }

        if(n.equals("11")){
            return "9";
        }

        long result = Long.MAX_VALUE;
        char[] nn = n.toCharArray();
        for(int i=0;i<n.length()/2;i++){
            nn[n.length()-i-1] = nn[i];
        }
        if(!new String(nn).equals(n)){
            result = Math.abs(result-Long.parseLong(n))
                    >Math.abs(Long.parseLong(n)-Long.parseLong(new String(nn)))?Long.parseLong(new String(nn)):
                    result;
        }


        nn = ((Long.parseLong(n)+a)+"").toCharArray();
        for(int i=0;i<nn.length/2;i++){
            nn[nn.length-i-1] = nn[i];
        }
        result = Math.abs(result-Long.parseLong(n))
                >Math.abs(Long.parseLong(n)-Long.parseLong(new String(nn)))?Long.parseLong(new String(nn)):
                result;

        nn = ((Long.parseLong(n)-a)+"").toCharArray();
        for(int i=0;i<nn.length/2;i++){
            nn[nn.length-i-1] = nn[i];
        }
        result = Math.abs(result-Long.parseLong(n))
                >=Math.abs(Long.parseLong(n)-Long.parseLong(new String(nn)))?Long.parseLong(new String(nn)):
                result;
        if(result>Long.parseLong(n)){
            long left = result-2*(result-Long.parseLong(n));
            if(isPalindrome((left+""))){
                return left+"";
            }
        }

        return result+"";
    }

    private static boolean isPalindrome(String a ){
        int start = 0;
        int end = a.length()-1;
        while (start<end){
            if(a.charAt(start++) != a.charAt(end--)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(nearestPalindromic("11"));
    }
}
