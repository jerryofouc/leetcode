package jerryofouc.github.io;

/**
 * Created by xiaojiez on 5/7/17.
 */
public class OutofBoundaryPaths {

    public static int findPaths(int m, int n, int N, int a, int b) {
        int[][][] mem = new int[51][51][51];
        int[][] direction ={{0,1},{0,-1},{1,0},{-1,0}};
        final int A = 1000000007;
        for(int i=1;i<=N;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<n;k++){
                    long sum = 0;
                    for(int d =0;d<direction.length;d++){
                        int nextI = j+direction[d][0];
                        int nextJ = k+direction[d][1];
                        if(nextI<0||nextI>=m || nextJ<0||nextJ>=n){
                            sum += 1;
                        }else {
                            sum += mem[i-1][nextI][nextJ];
                        }
                    }
                    mem[i][j][k] = (int)(sum%A);
                }
            }
        }
        return mem[N][a][b];
    }



    public static void main(String[] args) {
        System.out.println(findPaths(
                45,
                35,
                47,
                20,
                31));
    }
}
