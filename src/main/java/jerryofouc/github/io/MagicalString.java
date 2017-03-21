package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/21/17.
 */
public class MagicalString {
    public static int magicalString(int n) {
        if(n == 1){
            return 1;
        }
        int[] a = new int[2*n+10];
        a[0] = 1;
        a[1] = 2;
        a[2] = 2;
        a[0] = 1;
        int i = 3;
        int j = 2;
        while (i<=n){
            if(a[j] == 2){
                if(a[i-1] == 1){
                    a[i++] = 2;
                    a[i++] = 2;
                }else {
                    a[i++] = 1;
                    a[i++] = 1;
                }
            }else {
                if(a[i-1] == 1){
                    a[i++] = 2;
                }else {
                    a[i++] = 1;
                }
            }
            j++;
        }

        int sum = 0;
        for(i=0;i<n;i++){
            if(a[i] == 1){
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        magicalString(10);
    }
}
