package jerryofouc.github.io;

/**
 * Created by xiaojiez on 2/27/17.
 */
public class GuessNumberHigherorLowerII {


    public static int getMoneyAmount(int n) {
        int[][] table = new int[n+1][n+1];
        for(int i=1;i<=n-1;i++){
            for(int j=1;j+i<=n;j++){
                int min = Integer.MAX_VALUE;
                for(int x=j;x<=j+i;x++){
                    int left = 0;
                    if(x-1 >=j){
                        left = table[j][x-1];
                    }
                    int right = 0;
                    if(x+1<=j+i){
                        right = table[x+1][j+i];
                    }
                    if(min > x+Math.max(left,right)){
                        min = x+Math.max(left,right);
                    }
                }
                table[j][i+j] = min;
            }
        }
        return table[1][n];
    }



    public static void main(String[] args) {
        System.out.println(getMoneyAmount(100));
    }
}
