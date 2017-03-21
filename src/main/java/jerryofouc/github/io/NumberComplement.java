package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/21/17.
 */
public class NumberComplement {
    public static int findComplement(int num) {
        boolean isFirst = true;
        for(int i=31;i>=0;i--){
            if(isFirst) {
                if (((num & (1 << i)) != 0)) {
                    isFirst = false;
                    num = (num & (~(1 << i)));
                }
            }else {
                if (((num & (1 << i)) != 0)) {
                    num = (num & (~(1 << i)));
                }else {
                    num = (num | (1<<i));
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(findComplement(1));
    }


}
