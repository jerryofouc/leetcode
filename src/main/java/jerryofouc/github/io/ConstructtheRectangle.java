package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/22/17.
 */
public class ConstructtheRectangle {
    public int[] constructRectangle(int area) {
        int a = (int)Math.sqrt(area);
        for(int i=a;i>=1;i--){
            if(area%i == 0){
                return new int[]{area/i,i};
            }
        }
        throw new RuntimeException();

    }
}
