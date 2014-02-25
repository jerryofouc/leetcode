package jerryofouc.github.io;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 2/25/14
 * Time: 9:42
 * To change this template use File | Settings | File Templates.
 */
public class Candy {
    public static int candy(int[] ratings) {
        if (ratings == null && ratings.length == 0) {
            return 0;
        }
        if (ratings.length == 1) {
            return 1;
        }
        int[] tables = new int[ratings.length];
        tables[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                tables[i] = tables[i - 1] + 1;
            } else {
                tables[i] = 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] ) {
                if( tables[i] < tables[i + 1] + 1) {
                    tables[i] = tables[i + 1] + 1;
                }
            }
        }
        int sum = 0;
        for(int a : tables){
            sum += a;
        }
        return sum;
    }

    public static void main(String args[]) {
        int test[] = {2, 2, 3,3};
        System.out.println(candy(test));

    }


}
