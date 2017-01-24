package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by xiaojiez on 1/24/17.
 */
public class TheSkylineProblem {
    static class Tuple{
        public Tuple(int currentHeight, int lowerHeight) {
            this.currentHeight = currentHeight;
            this.lowerHeight = lowerHeight;
        }

        int currentHeight;
        int lowerHeight;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Tuple)) return false;

            Tuple tuple = (Tuple) o;

            if (currentHeight != tuple.currentHeight) return false;
            return lowerHeight == tuple.lowerHeight;
        }

        @Override
        public int hashCode() {
            int result = currentHeight;
            result = 31 * result + lowerHeight;
            return result;
        }
    }

    public static List<int[]> getSkyline(int[][] buildings) {
        TreeMap<Integer,Tuple> treeMap = new TreeMap<>();
        for(int i=0;i<buildings.length;i++){
            int li = buildings[i][0];
            int ri = buildings[i][1];
            int hi = buildings[i][2];
            int lh = 0;
            boolean ignoreI = false;

            for(int j=0;j<buildings.length;j++){
                if(j!=i){
                    int lj = buildings[j][0];
                    int rj = buildings[j][1];
                    int hj = buildings[j][2];
                    if(lj<=li&&li<=rj){
                        if(hj>hi){
                            ignoreI = true;
                            break;
                        }else {
                            if(hj>lh && li!=lj){
                                lh = hj;
                            }
                        }
                    }
                }
            }


            if(!ignoreI){
                treeMap.put(li,new Tuple(hi,lh));
            }
            boolean ignoreJ = false;
            lh = 0;
            for(int j=0;j<buildings.length;j++){
                if(j!=i){
                    int lj = buildings[j][0];
                    int rj = buildings[j][1];
                    int hj = buildings[j][2];
                    if(lj<=ri&&ri<=rj){
                        if(hj>hi){
                            ignoreJ = true;
                            break;
                        }else {
                            if(hj>lh && ri!=rj ){
                                lh = hj;
                            }
                        }
                    }
                }
            }

            if(!ignoreJ){
                treeMap.put(ri,new Tuple(hi,lh));
            }
        }
        List<int[]> result = new ArrayList<>();
        int i=0;
        for(Map.Entry<Integer,Tuple> entry : treeMap.entrySet()){
            int h ;
            if(i == 0){
                h = entry.getValue().currentHeight;
            }else {
                if(entry.getValue().currentHeight == result.get(result.size()-1)[1]){
                    h = entry.getValue().lowerHeight;
                }else {
                    h = entry.getValue().currentHeight;
                }
            }
            int[] a = new int[]{entry.getKey(),h};

            if(result.isEmpty() || result.get(result.size()-1)[1] != a[1]){
                result.add(a);
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] buildings = {{2, 9, 10}, {3 ,7, 15}, {5 ,12, 12}, {15, 20, 10}, {19, 24, 8} };
        int[][] buildings1 = {{1,2,1}, {1,2,2}, {1,2,3} };
        int[][] buildings3 = {{1,2,1}, {1,2,1} };
        int[][] buildings4 = {{0,5,7}, {5,10,7} ,{5,10,12},{10,15,7},{15,20,7},{15,20,12},{20,25,7}};
        getSkyline(buildings4);
    }
}
