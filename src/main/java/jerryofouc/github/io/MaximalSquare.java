package jerryofouc.github.io;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by xiaojiez on 1/25/17.
 */
public class MaximalSquare {
    static class Triple{

        public Triple(int i, int j, int l) {
            this.i = i;
            this.j = j;
            this.l = l;
        }

        int i;
        int j;
        int l;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Triple)) return false;

            Triple triple = (Triple) o;

            if (i != triple.i) return false;
            if (j != triple.j) return false;
            return l == triple.l;
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            result = 31 * result + l;
            return result;
        }
    }
    public static int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        if(matrix.length == 1){
            for(int i=0;i<matrix[0].length;i++){
                if(matrix[0][i] == '1'){
                    return 1;
                }
            }
        }

        if(matrix[0].length == 1){
            for(int i=0;i<matrix.length;i++){
                if(matrix[i][0] == '1'){
                    return 1;
                }
            }
        }

        int max = 0;

        Map<Triple,Boolean> map = new HashMap<>();
        for(int i=0;i<matrix.length-1;i++){
            for(int j=0;j<matrix[0].length-1;j++){
                if((matrix[i][j]=='1' || matrix[i+1][j]=='1' || matrix[i][j+1]=='1' || matrix[i+1][j+1] == '1')){
                    if(max == 0){
                        max =1;
                    }
                }
                if(matrix[i][j]=='1' && matrix[i+1][j]=='1' && matrix[i][j+1]=='1' && matrix[i+1][j+1] == '1'){
                    map.put(new Triple(i,j,2),true);
                    max = 2;
                }
            }
        }

        if(map.isEmpty()){
            return max;
        }
        for(int i=3;i<=Math.max(matrix.length,matrix[0].length);i++){
            Map<Triple,Boolean> curResult = new HashMap<>();
            Iterator<Map.Entry<Triple,Boolean>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<Triple,Boolean> entry = iterator.next();
                if(entry.getKey().l<i-1){
                    iterator.remove();
                }else {
                    if(entry.getKey().l == i-1){
                        Triple triple = entry.getKey();

                        if(map.containsKey(new Triple(triple.i+1,triple.j,i-1))&&
                                map.containsKey(new Triple(triple.i+1,triple.j+1,i-1))&&
                                map.containsKey(new Triple(triple.i,triple.j+1,i-1))

                                ){
                            max = i;
                            curResult.put(new Triple(entry.getKey().i,entry.getKey().j,i),true);
                        }
                    }
                }
            }
            map.putAll(curResult);

        }

        return max*max;
    }

    public static void main(String[] args) {
        char board[][] = new char[][]{
                "11100".toCharArray(),
                "11100".toCharArray(),
                "11111".toCharArray(),
                "01111".toCharArray(),
                "01111".toCharArray(),
                "01111".toCharArray()
        };
        char board1[][] = new char[][]{
                "1".toCharArray()
        };
        System.out.println(maximalSquare(board));;
    }
}
