package jerryofouc.github.io;

import java.util.*;

/**
 * Created by xiaojiez on 1/21/17.
 */
public class CourseSchedule {
    static class Edge{
        public Edge(int left, int right) {
            this.left = left;
            this.right = right;
        }

        int left;
        int right;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Edge)) return false;

            Edge edge = (Edge) o;

            if (left != edge.left) return false;
            return right == edge.right;
        }

        @Override
        public int hashCode() {
            int result = left;
            result = 31 * result + right;
            return result;
        }
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,Set<Edge>> sourceMap = new HashMap<Integer, Set<Edge>>();
        Map<Integer,Set<Edge>> targetMap = new HashMap<Integer, Set<Edge>>();
        for(int i=0;i<prerequisites.length;i++){
            Set<Edge> sourList = sourceMap.get(prerequisites[i][0]);
            if(sourList == null){
                sourList = new HashSet<Edge>();
                sourceMap.put(prerequisites[i][0],sourList);
            }
            sourList.add(new Edge(prerequisites[i][0],prerequisites[i][1]));

            Set<Edge> targetList = targetMap.get(prerequisites[i][1]);
            if(targetList == null){
                targetList = new HashSet<Edge>();
                targetMap.put(prerequisites[i][1],targetList);
            }
            targetList.add(new Edge(prerequisites[i][0],prerequisites[i][1]));
        }

        Set<Integer> finishedSet = new HashSet<Integer>();
        for(Map.Entry<Integer,Set<Edge>> entry : sourceMap.entrySet()){
            if(!finishedSet.contains(entry.getKey())){
                Set<Integer> currentSet = new HashSet<Integer>();
                if(!dfs(entry.getKey(),sourceMap,currentSet,finishedSet)){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean dfs(int start,Map<Integer, Set<Edge>> sourceMap, Set<Integer> currentSet, Set<Integer> finishedSet) {
        if(currentSet.contains(start)){
            return false;
        }
        if(finishedSet.contains(start)){
            return true;
        }
        currentSet.add(start);
        finishedSet.add(start);
        for(Edge e : sourceMap.get(start)){
            if(sourceMap.get(e.right) != null && !dfs(e.right,sourceMap,currentSet,finishedSet)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int nums[][] = new int[][]{
                {1,0},{2,1}
        };
        System.out.println(canFinish(2,nums));
    }
}
