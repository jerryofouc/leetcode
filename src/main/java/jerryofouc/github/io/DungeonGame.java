package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/19/17.
 */
public class DungeonGame {
    public static int calculateMinimumHP(int[][] dungeon) {
        int[][] mem = new int[dungeon.length][dungeon[0].length];
        for(int i=0;i<dungeon.length;i++){
            for(int j=0;j<dungeon[0].length;j++){
                mem[i][j]=-1;
            }
        }
        int result = calculateMinimumHP(dungeon,0,0,mem);
        if(result == 0) {
            result=1;
        }
        return result;
    }

    private static int calculateMinimumHP(int[][] dungeon, int i, int j,int[][] mem) {
        if(mem[i][j]>=0){
            return mem[i][j];
        }
         int m = dungeon.length-1,n= dungeon[0].length-1;
        int cur = dungeon[i][j];
        if(i == m && j==n){
            mem[i][j] = cur>0?0:(-cur+1);
            return cur>0?0:(-cur+1);
        }
        int right = 0;
        if(j<n){
            right = calculateMinimumHP(dungeon,i,j+1,mem);
        }else {
            right = Integer.MAX_VALUE;
        }
        int down = 0;
        if(i<m){
            down = calculateMinimumHP(dungeon,i+1,j,mem);
        }else {
            down = Integer.MAX_VALUE;
        }

        int result = -cur + Math.max(Math.min(right,down),1);
        if(result<0){
            result = 0;
        }
        mem[i][j] = result;
        return result;
    }

    public static void main(String[] args) {
        int[][] dungeon = new int[][]{
                {-2,-3,3},
                {-5,-10,1},
                {10,30,-5},
        };
        int[][] dungeon1 = new int[][]{
                {-3,5}
        };

        System.out.println(calculateMinimumHP(dungeon1));;
    }
}
