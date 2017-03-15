package jerryofouc.github.io;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaojiez on 3/14/17.
 */
public class NumberofBoomerangs {
    public static int numberOfBoomerangs(int[][] points) {
        int result = 0;
        for(int i=0;i<points.length;i++){
            Map<Double,Integer> map = new HashMap<>();
            for(int j=0;j<points.length;j++){
                if(i != j){
                    double d = Math.sqrt((points[i][0]-points[j][0])*(points[i][0]-points[j][0])+
                            (points[i][1]-points[j][1])*(points[i][1]-points[j][1]));
                    Integer a = map.get(d);
                    if(a == null){
                        a = 1;
                        map.put(d,a);
                    }else {
                        result += a*2;
                        map.put(d,++a);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{0,0},{1,0},{2,0}};
        System.out.println(numberOfBoomerangs(points));
    }


}
