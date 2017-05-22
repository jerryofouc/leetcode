package jerryofouc.github.io;

/**
 * Created by xiaojiez on 5/21/17.
 */
public class ValidSquare {
    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int len2 = (p1[0]-p2[0])*(p1[0]-p2[0])+(p1[1]-p2[1])*(p1[1]-p2[1]);
        int len3 = (p1[0]-p3[0])*(p1[0]-p3[0])+(p1[1]-p3[1])*(p1[1]-p3[1]);
        int len4 = (p1[0]-p4[0])*(p1[0]-p4[0])+(p1[1]-p4[1])*(p1[1]-p4[1]);
        if(len2 == 0 || len3 == 0 || len4 == 0){
            return false;
        }

        int[] a;
        int[] b;
        int[] c;
        int l2,l3,l4;
        if(len2 == len3){
            a = p2;
            b = p3;
            c = p4;
            l2 = len2;
            l3 = len3;
            l4 = len4;
        }else if(len3 == len4){
            a = p3;
            b = p4;
            c = p2;
            l2 = len3;
            l3 = len4;
            l4 = len2;
        }else if(len2 == len4){
            a = p2;
            b = p4;
            c = p3;
            l2 = len2;
            l3 = len4;
            l4 = len3;
        }else {
            return false;
        }

        if(l2 +l3 != l4){
            return false;
        }
        len2 = (c[0]-a[0])*(c[0]-a[0])+(c[1]-a[1])*(c[1]-a[1]);
        len3 = (c[0]-b[0])*(c[0]-b[0])+(c[1]-b[1])*(c[1]-b[1]);
        return len2==len3&&len2==l2;
    }

    public static void main(String[] args) {
        int[] p1 = {0,0};
        int[] p2 = {1,1};
        int[] p3 = {1,0};
        int[] p4 = {0,1};

        System.out.println(validSquare(p1,p2,p3,p4));

    }
}
