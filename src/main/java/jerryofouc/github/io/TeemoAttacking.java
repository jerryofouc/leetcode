package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/23/17.
 */
public class TeemoAttacking {
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0 || duration == 0) {
            return 0;
        }
        int nextEnd = 0;
        int sum = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            nextEnd = timeSeries[i] + duration;
            if (i + 1 < timeSeries.length && nextEnd > timeSeries[i + 1]) {
                nextEnd = timeSeries[i + 1];
            }
            sum += nextEnd - timeSeries[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(findPoisonedDuration(nums,2));
    }
}
