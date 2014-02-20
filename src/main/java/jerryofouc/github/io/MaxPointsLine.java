package jerryofouc.github.io;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 2/16/14
 * Time: 17:48
 * To change this template use File | Settings | File Templates.
 */
class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}

public class MaxPointsLine {
    public int maxPoints(Point[] points) {
        HashMap<Float, List<Set<Integer>>> map = new HashMap<Float, List<Set<Integer>>>();
        if(points.length == 0 || points.length == 1){
            return points.length;
        }
        int max=2;
        for(int i=0;i<points.length;i++){
            for(int j = i+1;j<points.length;j++){
                float slope = Float.MAX_VALUE;
                if(points[i].x - points[j].x != 0){
                    slope = ((float)(points[i].y - points[j].y))/(points[i].x - points[j].x);
                }
                if(map.get(slope) != null){
                    boolean isContains = false;
                    for(Set<Integer> list : map.get(slope)){
                        if(list.contains(i)){
                            list.add(j);
                            isContains = true;
                        }
                        if(list.contains(j)){
                            list.add(i);
                            isContains = true;
                        }
                        if(list.size()>max){
                            max = list.size();
                        }
                    }
                    if(!isContains){
                        Set<Integer> list = new HashSet<Integer>();
                        list.add(i);
                        list.add(j);
                        map.get(slope).add(list);
                    }
                }else{
                    Set<Integer> list = new HashSet<Integer>();
                    list.add(i);
                    list.add(j);
                    List<Set<Integer>> ll =  new ArrayList<Set<Integer>>();
                    ll.add(list);
                    map.put(slope,ll);
                }
            }
        }
        return max;
    }
    public static  void main(String args[]){
        Point[] points = {new Point(1,1),new Point(2,2),new Point(3,3),new Point(5,6),new Point(6,6)};
        System.out.println(new MaxPointsLine().maxPoints(points));
    }
}
