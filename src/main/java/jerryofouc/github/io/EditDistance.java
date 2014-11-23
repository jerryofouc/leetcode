package jerryofouc.github.io;

/**
 * @author zhangxiaojie
 *         2014-11-22 19:49
 *         功能介绍:
 */
public class EditDistance {


    public static void main(String args[]){
        System.out.println(minDistance("seaaaaa", "eat"));
    }
    public static int minDistance(String word1, String word2) {
        if(word1.length() == 0){
            return word2.length();
        }
        if(word2.length() == 0){
            return word1.length();
        }
        char[] wc1 = word1.toCharArray();
        char[] wc2 = word2.toCharArray();
        int[][] result = new int[wc1.length+1][wc2.length+1];

        for(int i=0;i<= wc2.length;i++){
            result[0][i] = i;
        }

        for(int i=0;i<=wc1.length;i++){
            result[i][0] = i;
        }

        for(int i=0;i<wc1.length;i++){
            for(int j=0;j<wc2.length;j++){
                result[i+1][j+1] = Math.min(result[i][j]+((wc1[i]==wc2[j])?0:1),Math.min(result[i][j+1]+1,result[i+1][j]+1));
            }
        }

        return result[wc1.length][wc2.length];

    }


}
