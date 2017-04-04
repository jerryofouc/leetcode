package jerryofouc.github.io;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaojiez on 4/2/17.
 */
public class FriendCircles {

    public static int findCircleNum(int[][] M) {
        Set<Integer> tupleSet = new HashSet<>();
        if(M.length == 0 || M[0].length == 0){
            return 0;
        }
        int result = 0;
        for(int i=0;i<M.length;i++) {
            if (!tupleSet.contains(i)) {
                dfs(i,M,tupleSet);
                result++;
            }
        }
        return result;
    }

    private static void dfs(int k, int[][] m, Set<Integer> tupleSet) {
        if(!tupleSet.contains(k)){
            tupleSet.add(k);
            for(int i=0;i<m[0].length;i++){
                if(i != k && m[k][i] == 1){
                    dfs(i,m,tupleSet);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] m = {{1,1,0},
                {1,1,1},
                {0,1,1}};
        System.out.println(findCircleNum(m));
    }
}
