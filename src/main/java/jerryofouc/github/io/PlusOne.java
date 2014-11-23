package jerryofouc.github.io;

/**
 * @author zhangxiaojie
 *         2014-11-22 22:35
 *         功能介绍:
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carray = 1;
        for(int i=digits.length-1;i>=0;i--){
            digits[i] += carray;
            if(digits[i] == 10){
                digits[i] = 0;
                carray = 1;
            }else {
                carray = 0;
            }
        }
        int[] result = digits;
        if(carray == 1){
            result = new int[digits.length +1];
            result[0] = 1;
            for(int i= 0;i<digits.length;i++){
                result[i+1] = digits[i];
            }
        }
        return result;

    }


}
