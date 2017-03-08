package jerryofouc.github.io;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by xiaojiez on 3/8/17.
 */
public class TrappingRainWaterII {
    static class Cell{
        int i;
        int j;
        int k;

        public Cell(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if(heightMap.length ==0||heightMap[0].length == 0){
            return 0;
        }
        PriorityQueue<Cell> queue = new PriorityQueue<>(new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                if(o1.k<o2.k){
                    return -1;
                }else if(o1.k>o2.k){
                    return 1;
                }else {
                    return 0;
                }
            }
        });

        boolean[][] visited = new boolean[heightMap.length][heightMap[0].length];

        for(int i=0;i<heightMap.length;i++){
            queue.add(new Cell(i,0,heightMap[i][0]));
            queue.add(new Cell(i,heightMap[i].length-1,heightMap[i][heightMap[i].length-1]));
            visited[i][0] = true;
            visited[i][heightMap[i].length-1] = true;
        }

        for(int i=0;i<heightMap[0].length;i++){
            queue.add(new Cell(0,i,heightMap[0][i]));
            queue.add(new Cell(heightMap.length-1,i,heightMap[heightMap.length-1][i]));
            visited[0][i] = true;
            visited[heightMap.length-1][i] = true;
        }

        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int result = 0;
        while (!queue.isEmpty()){
            Cell cell = queue.poll();
            for(int i=0;i<dir.length;i++){
                int nextI =cell.i+dir[i][0];
                int nextJ = cell.j+dir[i][1];
                if(nextI<heightMap.length
                        &&nextI>=0
                        &&nextJ<heightMap[0].length
                        &&nextJ>=0&&!visited[nextI][nextJ]){
                    result += Math.max(0,cell.k-heightMap[nextI][nextJ]);
                    queue.add(new Cell(nextI,nextJ,Math.max(cell.k,heightMap[nextI][nextJ])));
                    visited[nextI][nextJ] = true;
                }
            }
        }
        return result;
    }
}
