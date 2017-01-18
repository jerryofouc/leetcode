package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/18/17.
 */
public class ExcelSheetColumnNumber {
    public static int titleToNumber(String s) {
        int x=0;
        for(int i=0;i<s.length();i++){
            x *= 26;
            x += s.charAt(i)-'A'+1;
        }
        return x;
    }
}
