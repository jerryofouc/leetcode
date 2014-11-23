package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxiaojie
 *         2014-11-23 14:16
 *         功能介绍:
 */
public class PermutationSequence {

    public static void main(String args[]) {
        getPermutation(3, 2);
    }

    public static String getPermutation(int n, int k) {
        k = k-1;
        List<Integer> ll = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            ll.add(i);
        }

        String result = "";
        for (int i = n - 1; i >= 0; i--) {
            int a = k / getK(i);
            result += ll.get(a);
            ll.remove(a);
            k = k % getK(i);
        }
        return result;
    }

    private static int getK(int k) {
        int r = 1;
        for (int i = 1; i <= k; i++) {
            r *= i;
        }
        return r;
    }
}
