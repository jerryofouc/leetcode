package jerryofouc.github.io;

/**
 * @author zhangxiaojie
 *         2014-11-23 13:35
 *         功能介绍:
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] temp = new int[m][n];
        temp[0][0] = 1;
        for(int i=1;i<m;i++){
            temp[i][0] = 1;
        }

        for(int i=1;i<n;i++){
            temp[0][i] = 1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                temp[i][j] = temp[i-1][j] + temp[i][j-1];
            }
        }


        return temp[m-1][n-1];

    }
}
