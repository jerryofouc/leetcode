package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/27/17.
 */
public class ComplexNumberMultiplication {
    public static String complexNumberMultiply(String a, String b) {
        String[] aa = a.split("\\+");
        int i1 = Integer.parseInt(aa[0]);
        int i2 = Integer.parseInt(aa[1].substring(0,aa[1].length()-1));

        String[] bb = b.split("\\+");
        int j1 = Integer.parseInt(bb[0]);
        int j2 = Integer.parseInt(bb[1].substring(0,bb[1].length()-1));

        Integer r1 = i1*j1 -i2*j2;
        Integer r2 = i1*j2+i2*j1;

        return r1+"+" +(r2)+"i";
    }

    public static void main(String[] args) {
        System.out.println(complexNumberMultiply("1+-1i","1+-1i"));
    }
}
