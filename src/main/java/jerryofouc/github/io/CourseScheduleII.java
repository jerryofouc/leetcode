package jerryofouc.github.io;

import java.util.*;

/**
 * Created by xiaojiez on 1/22/17.
 */
public class CourseScheduleII {
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
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
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

        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        Set<Integer> finishedSet  = new HashSet<Integer>();
        for(Map.Entry<Integer,Set<Edge>> entry : sourceMap.entrySet()){
            if(!finishedSet.contains(entry.getKey())){
                List<Integer> currentList = new ArrayList<Integer>();
                if(!dfs(entry.getKey(),sourceMap,currentList,finishedSet)){
                    return new int[]{};
                }
                for(int i=currentList.size()-1;i>=0;i--){
                    linkedList.addFirst(currentList.get(i));
                }
            }
        }
        int [] a = new int[numCourses];
        int i = 0;
        LinkedList<Integer> reverse = new LinkedList<Integer>();

        for(Integer k : linkedList){
            reverse.addFirst(k);
        }

        for(Integer k :reverse){
            a[i] = k;
            i++;
        }

        for(int j=0;j<numCourses;j++){
            if(!finishedSet.contains(j)){
                a[i] = j;
                i++;
            }
        }


        return a;
    }

    private static boolean dfs(int start, Map<Integer, Set<Edge>> sourceMap, List<Integer> currentSet,
                               Set<Integer> finishedSet) {
        if(currentSet.contains(start)){
            return false;
        }
        if(finishedSet.contains(start)){
            return true;
        }
        currentSet.add(start);
        finishedSet.add(start);
        for(Edge e : sourceMap.get(start)){
            if(sourceMap.get(e.right) == null && !finishedSet.contains(e.right)){
                currentSet.add(e.right);
                finishedSet.add(e.right);
            }else if(sourceMap.get(e.right) != null && !dfs(e.right,sourceMap,currentSet,finishedSet)){
                return false;
            }
        }
        return true;
    }

        public static void main(String[] args) {
            int nums[][] = new int[][]{

            };
            System.out.println(findOrder(2,nums));

    }
}
