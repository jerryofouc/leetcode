package jerryofouc.github.io;

import java.util.Arrays;

/**
 * Created by xiaojiez on 3/16/17.
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);
        int result = 0;
        for(int i=0,j=0;i<g.length&&j<s.length;){
            if(g[i]<=s[j]){
                result++;
                i++;
                j++;
            }else {
                j++;
            }
        }
        return result;
    }
}
