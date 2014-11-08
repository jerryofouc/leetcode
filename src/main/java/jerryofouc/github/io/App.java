package jerryofouc.github.io;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App 
{
    private static String REGX_TXTMATERIAL_ID = ".*[^A-Za-z]id=(\\d+).*";

    public static void main( String[] args )
    {
        int j = 1;



        for(long i=0;i<10000000;i++){
            j++;
            if(i%5000 == 0){
                System.out.println(i + " ");
            }
        }
        System.out.println(j);
    }
}
