package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/20/17.
 */
public class OnesAndZeroes {
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][][] mem = new int[m+1][n+1][strs.length];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                for(int k=0;k<strs.length;k++){
                    mem[i][j][k] = -1;
                }
            }
        }

        return find(strs,m,n,strs.length-1,mem);
    }

    private static int find(String[] strs, int m, int n, int i, int[][][] mem) {
        if(m < 0 || n < 0||i<0){
            return 0;
        }

        if(mem[m][n][i] != -1){
            return mem[m][n][i];
        }

        int[] aa = getStr(strs[i]);
        int a = find(strs,m,n,i-1,mem);
        int b = 0;
        if(m>=aa[0] &&n>=aa[1]){
            b = find(strs,m-aa[0],n-aa[1],i-1,mem)+1;
        }
        mem[m][n][i] = Math.max(a,b);
        return mem[m][n][i];
    }

    private static int[] getStr(String str) {
        int[] a = new int[2];
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '1'){
                a[1]++;
            }else {
                a[0]++;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        String[] str = new String[]{"10", "0", "1"};
        System.out.println(findMaxForm(str,1,1));
    }
}
