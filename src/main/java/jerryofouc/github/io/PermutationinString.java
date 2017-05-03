package jerryofouc.github.io;

/**
 * Created by xiaojiez on 5/3/17.
 */
public class PermutationinString {
    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int[][] sum = new int[s2.length()+1][26];
        for(int i=0;i<s2.length();i++){
            sum[i+1][s2.charAt(i)-'a']++;
            for(int j=0;j<26;j++){
                sum[i+1][j] += sum[i][j];
            }
        }

        int[] a = new int[26];
        for(int i=0;i<s1.length();i++){
            a[s1.charAt(i)-'a']++;
        }
        for(int i=s1.length();i<=s2.length();i++){
            int[] b = new int[26];
            boolean isEqual = true;
            for(int j=0;j<26;j++){
                b[j] += sum[i][j]-sum[i-s1.length()][j];
                if(b[j] != a[j]){
                    isEqual = false;
                    break;
                }
            }

            if(isEqual){
                return true;
            }

        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ba","eidboaoo"));
    }
}
