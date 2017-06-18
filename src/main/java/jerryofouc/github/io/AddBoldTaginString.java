package jerryofouc.github.io;

/**
 * Created by xiaojiez on 6/11/17.
 */
public class AddBoldTaginString {

    public static String addBoldTag(String s, String[] dict) {
        boolean[] a = new boolean[s.length()];
        for(int i=0;i<dict.length;i++){
            for(int j=0;j<s.length();){
                int index = s.indexOf(dict[i],j);
                if(index<0){
                    break;
                }else {
                    for(int k=index;k<index+dict[i].length();k++){
                        a[k] = true;
                    }
                    j = index+1;
                }
            }
        }

        String result = "";
        int state = 0;
        for(int i=0;i<s.length();i++){
            if(state == 0){
                if(a[i]){
                    result += "<b>";
                    state=1;
                }
            }else {
                if(!a[i]){
                    result += "</b>";
                    state = 0;
                }
            }
            result+=s.charAt(i);
        }
        if(state == 1){
            result += "</b>";
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "aaabbcc";
        String[] a = new String[]{"aaa","aab","bc"};
        System.out.println(addBoldTag(s,a));
    }


}
