package jerryofouc.github.io;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by xiaojiez on 3/8/17.
 */
public class QueueReconstructionByHeight {


    public static int[][] reconstructQueue(int[][] people) {
        if(people.length == 0){
            return people;
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]<o2[0]){
                    return 1;
                }else if(o1[0]>o2[0]){
                    return -1;
                }else {
                    if(o1[1]>o2[1]){
                        return 1;
                    }else if(o1[1]<o2[1]){
                        return -1;
                    }else {
                        return 0;
                    }
                }
            }
        });
        int[] p = people[0];
        int i=1;
        for(;i<people.length;i++){
            if(people[i][0] != p[0]){
                break;
            }
        }

        for(;i<people.length;i++){
            int[] temp = people[i];
            int k = temp[1];
            for(int j=i-1;j>=k;j--){
                people[j+1] = people[j];
            }
            people[k] = temp;
        }
        return people;
    }

    public static void main(String[] args) {
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        reconstructQueue(people);
    }
}
