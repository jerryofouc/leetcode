package jerryofouc.github.io;

/**
 * @author zhangxiaojie
 *         2014-11-23 13:40
 *         功能介绍:
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] temp = new int[m][n];
        if(obstacleGrid[0][0] == 1){
            return 0;
        }

        temp[0][0] = 1;
        for(int i=1;i<m;i++){
            if(obstacleGrid[i][0] == 1){
                temp[i][0] = 0;
            }else {
                temp[i][0] = temp[i-1][0];
            }
        }

        for(int i=1;i<n;i++){
            if(obstacleGrid[0][i] == 1){
                temp[0][i] = 0;
            }else {
                temp[0][i] = temp[0][i-1];
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j] == 1){
                    temp[i][j] = 0;
                }else {
                    temp[i][j] = temp[i-1][j] + temp[i][j-1];
                }
            }
        }


        return temp[m-1][n-1];
    }
}
