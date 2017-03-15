package jerryofouc.github.io;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by xiaojiez on 3/15/17.
 */
public class MinimumNumberofArrowstoBurstBalloons {
    public static int findMinArrowShots(int[][] points) {
        if(points == null ){
            return 0;
        }
        if(points.length<=1){
            return points.length;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]<o2[0]){
                    return -1;
                }else if(o1[0]>o2[0]){
                    return 1;
                }else {
                    return 0;
                }
            }
        });

        for(int i=0;i<points.length;i++){
            queue.add(points[i]);
        }

        int[] cur = queue.poll();
        int result = 0;
        while (!queue.isEmpty()){
            int[] cur1 = queue.poll();
            if(cur1[0]>cur[1]){
                result++;
                cur = cur1;
            }else {
                cur[0] = Math.max(cur[0],cur1[0]);
                cur[1] = Math.min(cur[1],cur1[1]);
            }
        }
        return result+1;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{10,16}, {2,8}, {1,6}, {7,12}};
        int[][] nums1 = new int[][]{{1,2}, {2,3}, {3,4}, {4,5}};
        System.out.println(findMinArrowShots(nums1));
    }


}
