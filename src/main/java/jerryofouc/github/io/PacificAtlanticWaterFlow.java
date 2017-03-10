package jerryofouc.github.io;

import java.util.*;

/**
 * Created by xiaojiez on 3/9/17.
 */
public class PacificAtlanticWaterFlow {
    static class Cell{
        int i;
        int j;
        int h;

        public Cell(int i, int j, int h) {
            this.i = i;
            this.j = j;
            this.h = h;
        }
    }

    static class Tuple{
        int i;
        int j;

        public Tuple(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Tuple)) return false;

            Tuple tuple = (Tuple) o;

            if (i != tuple.i) return false;
            return j == tuple.j;
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }
    }
    public static List<int[]> pacificAtlantic(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return new ArrayList<>();
        }
        Set<Tuple> pSet = new HashSet<>();
        PriorityQueue<Cell> priorityQueue = new PriorityQueue<>(new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                if(o1.h>o2.h){
                    return 1;
                }else if(o1.h<o2.h){
                    return -1;
                }else {
                    return 0;
                }
            }
        });

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for(int i=0;i<matrix[0].length;i++){
            priorityQueue.add(new Cell(0, i, matrix[0][i]));
            pSet.add(new Tuple(0,i));
            visited[0][i] = true;
        }

        for(int i=0;i<matrix.length;i++){
            priorityQueue.add(new Cell(i, 0, matrix[i][0]));
            pSet.add(new Tuple(i,0));
            visited[i][0] = true;
        }

        int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        while (!priorityQueue.isEmpty()){
            Cell cell = priorityQueue.poll();
            for(int i=0;i<dir.length;i++){
                int nextI = cell.i+dir[i][0];
                int nextJ = cell.j+dir[i][1];
                if(nextI>=0&&nextI<matrix.length&&nextJ>=0&&nextJ<matrix[0].length&&!visited[nextI][nextJ]){
                    if(cell.h ==Integer.MAX_VALUE || cell.h>matrix[nextI][nextJ]){
                        priorityQueue.add(new Cell(nextI,nextJ,Integer.MAX_VALUE));
                    }else {
                        pSet.add(new Tuple(nextI,nextJ));
                        priorityQueue.add(new Cell(nextI,nextJ,matrix[nextI][nextJ]));
                    }
                    visited[nextI][nextJ] = true;
                }
            }
        }

        Set<Tuple> aSet = new HashSet<>();
        visited = new boolean[matrix.length][matrix[0].length];

        for(int i=0;i<matrix[0].length;i++){
            priorityQueue.add(new Cell(matrix.length-1, i, matrix[matrix.length-1][i]));
            aSet.add(new Tuple(matrix.length-1,i));
            visited[matrix.length-1][i] = true;
        }

        for(int i=0;i<matrix.length;i++){
            priorityQueue.add(new Cell(i, matrix[0].length-1, matrix[i][matrix[0].length-1]));
            aSet.add(new Tuple(i,matrix[0].length-1));
            visited[i][matrix[0].length-1] = true;

        }


        while (!priorityQueue.isEmpty()){
            Cell cell = priorityQueue.poll();
            for(int i=0;i<dir.length;i++){
                int nextI = cell.i+dir[i][0];
                int nextJ = cell.j+dir[i][1];
                if(nextI>=0&&nextI<matrix.length&&nextJ>=0&&nextJ<matrix[0].length&&!visited[nextI][nextJ]){
                    if(cell.h ==Integer.MAX_VALUE || cell.h>matrix[nextI][nextJ]){
                        priorityQueue.add(new Cell(nextI,nextJ,Integer.MAX_VALUE));
                    }else {
                        aSet.add(new Tuple(nextI,nextJ));
                        priorityQueue.add(new Cell(nextI,nextJ,matrix[nextI][nextJ]));
                    }
                    visited[nextI][nextJ] = true;
                }
            }
        }


        List<int[]> result = new ArrayList<>();
        for(Tuple t : pSet){
            if(aSet.contains(t)){
                result.add(new int[]{t.i,t.j});
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1 ,  2  , 2  , 3,5},{3 ,  2  , 3 , 4,4},{ 2 ,  4,  5,  3 ,  1},{6 ,7  ,1  , 4   ,5},{5,  1  , 1  , 2  , 4 }};
        pacificAtlantic(matrix);
    }


}
