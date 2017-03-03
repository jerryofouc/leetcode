package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/3/17.
 */
public class UTF8Validation {
    public static boolean validUtf8(int[] data) {
        boolean start = true;
        int count = 0;
        for(int i=0;i<data.length;i++){
            if(data[i]>255||data[i]<0){
                return false;
            }
            if(start){
                int ones = getOneNum(data[i]);
                if(ones ==0 ){
                    continue;
                }else if (ones >=2 && ones<=4){
                    start = false;
                    count = ones-1;
                }else {
                    return false;
                }
            }else {
                int ones = getOneNum(data[i]);
                if(ones != 1){
                    return false;
                }
                count--;
                if(count == 0){
                    start = true;
                }
            }
        }
        return count == 0;
    }

    private static int getOneNum(int k) {
        int a = 0x80;
        int count = 0;
        while ((k&a) != 0){
            a = (a>>1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] data = new int[]{197, 130, 1};
        System.out.println(validUtf8(data));
    }
}
