package jerryofouc.github.io;

/**
 * @author zhangxiaojie
 *         2014-11-22 21:15
 *         功能介绍:
 */
public class ClimbingStairs {
    public int sqrt(int x) {
        int low = 0, high = 46340;
        int mid = 0;


        while (true) {
            mid = (low + high) / 2;
            if (mid * mid == x)
                return mid;
            else if (mid * mid > x)
                high = mid;
            else// mid*mid < x;
                low = mid;

            if (low == high - 1) {
                if (high * high <= x)
                    return high;
                else if (low * low <= x)
                    return low;
            }
        }
    }
}
