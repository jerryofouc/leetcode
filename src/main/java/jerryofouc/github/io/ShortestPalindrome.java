package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/24/17.
 */
public class ShortestPalindrome {
    public static String shortestPalindrome(String s) {
        StringBuilder a = new StringBuilder();
        for(int i = s.length()-1;i>=0;i--){
            if(isPalindrome(0,i,s)){
                break;
            }else {
                a.append(s.charAt(i));
            }
        }
        return a+s;


    }

    private static boolean isPalindrome(int i,int j,String s){
        while (i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("abba"));
    }
}
