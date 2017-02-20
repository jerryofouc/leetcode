package jerryofouc.github.io;

/**
 * Created by xiaojiez on 2/20/17.
 */
public class CountingBits {
    public static int[] countBits(int num) {
        if(num == 0){
            return new int[]{0};
        }
        int[] result = new int[num+1];
        result[0] =0;
        result[1] = 1;
        int k = 2;
        int t = 0;
        for(int i=2;i<num+1;i++){
            result[i] = 1+result[i-k];
            t ++;
            if(t == k){
                k = (k<<1);
                t = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countBits(5));
    }


}
