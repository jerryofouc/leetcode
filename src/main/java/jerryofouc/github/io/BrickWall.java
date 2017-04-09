package jerryofouc.github.io;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaojiez on 4/9/17.
 */
public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        int max = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<wall.size();i++){
            int sum = 0;
            for(int j=0;j<wall.get(i).size();j++){
                if(j !=wall.get(i).size()-1 ){
                    sum += wall.get(i).get(j);
                    int cur =  map.getOrDefault(sum,0);
                    map.put(sum,cur+1);
                    max = Math.max(cur+1,max);
                }

            }
        }
        return wall.size()-max;
    }
}
