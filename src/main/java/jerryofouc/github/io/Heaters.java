package jerryofouc.github.io;

import java.util.Arrays;

/**
 * Created by xiaojiez on 3/20/17.
 */
public class Heaters {
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int i = 0;
        int maxRadius = 0;
        while (i<houses.length&&heaters[0]>houses[i]){
            maxRadius = heaters[0] - houses[0];
            i++;
        }

        if(i == houses.length){
            return maxRadius;
        }
        int start = i;

        i =houses.length-1;
        while (i>=0&&heaters[heaters.length-1]<houses[i]){
            maxRadius = Math.max(maxRadius,houses[i]-heaters[heaters.length-1]);
            i--;
        }
        if(i<0){
            return maxRadius;
        }
        int end = i;
        if(start>end){
            return maxRadius;
        }

        if(heaters.length == 1){
            return maxRadius;
        }

        for(i=0;i+1<heaters.length;i++){
            int first = heaters[i];
            int second = heaters[i+1];
            while (start<houses.length&&houses[start]<second){
                maxRadius = Math.max(Math.min(houses[start]-first,second-houses[start]),maxRadius);
                start++;
            }
            if(start>end || start>=houses.length){
                break;
            }
        }
        return maxRadius;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int [] b = {10};
        System.out.println(findRadius(a,b));
    }
}
