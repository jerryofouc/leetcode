package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/17/17.
 */
public class CompareVersionNumbers {
    public static int compareVersion(String version1, String version2) {
        String[] a1 = version1.split("\\.");
        String[] a2 = version2.split("\\.");
        int l = a1.length>a2.length?a2.length:a1.length;
        for(int i=0;i<l;i++){
            if(Integer.parseInt(a1[i]) < Integer.parseInt(a2[i])){
                return -1;
            }else if(Integer.parseInt(a1[i]) > Integer.parseInt(a2[i])){
                return 1;
            }
        }
        if(a1.length>a2.length){
            for(int i=l;i<a1.length;i++){
                if(Integer.parseInt(a1[i])>0){
                    return 1;
                }
            }
            return 0;
        }else if(a1.length<a2.length){
            for(int i=l;i<a2.length;i++){
                if(Integer.parseInt(a2[i])>0){
                    return -1;
                }
            }
            return 0;
        }
        return 0;
    }

}
