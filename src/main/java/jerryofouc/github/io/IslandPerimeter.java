package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/18/17.
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int[][] direction = {{0,1},{0,-1},{-1,0},{1,0}};
        int result = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 0 ){
                    continue;
                }
                for(int k=0;i<direction.length;k++){
                    int nextI = i+direction[k][0];
                    int nextJ = j+direction[k][1];
                    if(nextI==grid.length||nextI<0||nextJ==grid[0].length||nextJ<0||grid[nextI][nextJ]==0){
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
