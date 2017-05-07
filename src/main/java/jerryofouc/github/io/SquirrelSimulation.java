package jerryofouc.github.io;

/**
 * Created by xiaojiez on 5/7/17.
 */
public class SquirrelSimulation {
    public static int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int sum = 0;
        for(int i=0;i<nuts.length;i++){
            sum += 2*(Math.abs(nuts[i][0]-tree[0])+Math.abs(nuts[i][1]-tree[1]));
        }
        int result = Integer.MAX_VALUE;
        for(int i=0;i<nuts.length;i++){
            result = Math.min(result,sum-(Math.abs(nuts[i][0]-tree[0])+Math.abs(nuts[i][1]-tree[1]))+
                    (Math.abs(nuts[i][0]-squirrel[0])+Math.abs(nuts[i][1]-squirrel[1])));
        }

        return result;
    }

    public static void main(String[] args) {
        int[] tree = {2,2};
        int[] squirrel = {4,4};
        int[][] nuts = {{3,0}, {2,5}};
        System.out.println(minDistance(5,7,tree,squirrel,nuts));
    }
}
