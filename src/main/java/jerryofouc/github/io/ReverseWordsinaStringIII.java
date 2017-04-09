package jerryofouc.github.io;

/**
 * Created by xiaojiez on 4/9/17.
 */
public class ReverseWordsinaStringIII {
    public static String reverseWords(String s) {
        String[] a = s.split(" ");
        for(int i=0;i<a.length;i++){
            a[i] = new StringBuilder(a[i]).reverse().toString();
        }
        return String.join(" ",a);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
