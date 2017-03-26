package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xiaojiez on 3/26/17.
 */
public class Matrix01 {
    static class Tuple{
        public Tuple(int i, int j) {
            this.i = i;
            this.j = j;
        }

        int i;
        int j;

    }
    public static List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        int[][] array = new int[matrix.size()][matrix.get(0).size()];
        Queue<Tuple> tupleQueue = new LinkedList<>();
        for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix.get(0).size();j++){
                int value = matrix.get(i).get(j);
                if(value == 0){
                    array[i][j] = value;
                    tupleQueue.add(new Tuple(i,j));
                }else {
                    array[i][j] = -1;
                }
            }
        }

        int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
        int step = 1;
        while (true){
            Queue<Tuple> tempQueue = new LinkedList<>();

            while (!tupleQueue.isEmpty()){
                Tuple tuple = tupleQueue.poll();
                for(int i=0;i<direction.length;i++){
                   int ii = tuple.i + direction[i][0];
                   int jj = tuple.j + direction[i][1];
                   if(ii>=0&&ii<array.length&&jj>=0&&jj<array[0].length){
                       if(array[ii][jj] == -1){
                           tempQueue.add(new Tuple(ii,jj));
                           array[ii][jj] = step;
                       }
                   }
                }
            }
            step++;
            if(tempQueue.isEmpty()){
                break;
            }else {
                tupleQueue = tempQueue;
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<array.length;i++){
            List<Integer> l = new ArrayList<>();
            for(int j=0;j<array[0].length;j++){
                l.add(array[i][j]);
            }
            result.add(l);
        }

        return result;

    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{0 ,0 ,0},
                {0, 1, 0},
                {1, 1, 1}};
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<array.length;i++){
            List<Integer> l = new ArrayList<>();
            for(int j=0;j<array[0].length;j++){
                l.add(array[i][j]);
            }
            result.add(l);
        }
        System.out.println(updateMatrix(result));

    }


}
