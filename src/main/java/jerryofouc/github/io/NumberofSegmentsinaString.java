package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/12/17.
 */
public class NumberofSegmentsinaString {
    public static int countSegments(String s) {
        if(s == null || s.trim().length() == 0){
            return 0;
        }

        s = s.trim();
        return s.split("[ \t\n]+").length;
    }

    public static void main(String[] args) {
        System.out.println(countSegments(", , , ,        a, eaefa"));
    }
}
