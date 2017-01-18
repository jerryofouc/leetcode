package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/18/17.
 */
public class ExcelSheetColumnTitle {
    public static String convertToTitle(int n) {
        n=n-1;
        String result = "";
        while (n/26!=0){
            result = (char)(n%26 +'A')+result;
            n = n/26-1;
        }
        result = (char)(n%26 +'A')+result;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(28));
    }
}
