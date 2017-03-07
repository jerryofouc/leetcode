package jerryofouc.github.io;

import java.util.*;

/**
 * Created by xiaojiez on 3/4/17.
 */
public class EvaluateDivision {
    static class Tuple{
        String left;
        String right;

        public Tuple(String left, String right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Tuple)) return false;

            Tuple tuple = (Tuple) o;

            if (left != null ? !left.equals(tuple.left) : tuple.left != null) return false;
            return right != null ? right.equals(tuple.right) : tuple.right == null;
        }

        @Override
        public int hashCode() {
            int result = left != null ? left.hashCode() : 0;
            result = 31 * result + (right != null ? right.hashCode() : 0);
            return result;
        }
    }
    public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<Tuple,Double> edges = new HashMap<>();
        List<String> vertexList = new ArrayList<>();
        Set<String> vertexSet = new HashSet<>();

        for(int i=0;i<equations.length;i++){
            String[] edge = equations[i];
            edges.put(new Tuple(edge[0],edge[1]),values[i]);
            edges.put(new Tuple(edge[1],edge[0]),1/values[i]);
            if(!vertexSet.contains(edge[0])){
                vertexSet.add(edge[0]);
                vertexList.add(edge[0]);
            }
            if(!vertexSet.contains(edge[1])){
                vertexSet.add(edge[1]);
                vertexList.add(edge[1]);
            }
        }


        for(int i=0;i<vertexList.size();i++){
            for(int j=0;j<vertexList.size();j++){
                for(int k=0;k<vertexList.size();k++){
                    if(!edges.containsKey(new Tuple(vertexList.get(i),vertexList.get(j)))&&
                            edges.containsKey(new Tuple(vertexList.get(i),vertexList.get(k)))&&
                            edges.containsKey(new Tuple(vertexList.get(k),vertexList.get(j)))){
                        edges.put(new Tuple(vertexList.get(i),vertexList.get(j)),
                                edges.get(new Tuple(vertexList.get(i),vertexList.get(k)))*edges.get(new Tuple(vertexList.get(k),vertexList.get(j))));
                    }
                }
            }
        }
        double[] q = new double[queries.length];

        for(int i=0;i<queries.length;i++){
            if(edges.containsKey(new Tuple(queries[i][0],queries[i][1]))){
                q[i] = edges.get(new Tuple(queries[i][0],queries[i][1]));
            }else {
                q[i] = -1;
            }
        }

        return q;
    }

}
