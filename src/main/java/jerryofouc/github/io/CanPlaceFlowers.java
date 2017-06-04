package jerryofouc.github.io;

/**
 * Created by xiaojiez on 6/4/17.
 */
public class CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0){
            return true;
        }
        for(int i=0;i<flowerbed.length;i++){
            if((i-1<0||flowerbed[i-1]==0) && (flowerbed[i] == 0) && (i+1==flowerbed.length||flowerbed[i+1]==0)){
                n--;
                flowerbed[i] = 1;
                if(n==0){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] flowerbed = new int[]{1,0,0,0,1};
        System.out.println(canPlaceFlowers(flowerbed,1));
    }
}
