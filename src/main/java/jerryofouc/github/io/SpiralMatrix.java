package jerryofouc.github.io;

/**
 * @author zhangxiaojie
 *         2014-11-23 22:05
 *         功能介绍:
 */
public class SpiralMatrix {
    public static void main(String args[]){
        System.out.println(generateMatrix(3));
    }

    public static int[][] generateMatrix(int n) {

        int[][] array = new int[n+2][n+2];
        for(int i=0;i<n+2;i++){
            array[0][i] = -1;
            array[i][0] = -1;
            array[n+1][i] = -1;
            array[i][n+1] = -1;
        }

        int direction = 0;
        int k=1;
        int x = 1;
        int y = 1;
        while(k<=n*n){
            if(array[x][y] == 0){
                array[x][y] = k++;
            }else {
                if(direction == 0){
                    y = y-1;
                }else if(direction == 1){
                    x = x-1;
                }else if(direction == 2){
                    y = y+1;
                }else if(direction == 3){
                    x = x+1;
                }
                direction = (direction+1)%4;
            }
            if(direction == 0){
                y = y+1;
            }else if(direction == 1){
                x = x+1;
            }else if(direction == 2){
                y = y-1;
            }else if(direction == 3){
                x = x-1;
            }
        }

        int[][] result = new int[n][n];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                result[i-1][j-1] =  array[i][j];
            }
        }
        return result;
    }
}
