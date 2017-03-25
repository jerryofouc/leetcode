package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/25/17.
 */
public class DetectCapital {
    public boolean detectCapitalUse(String word) {

        if(word.length() == 1){
            return !isCapital(word.charAt(0));
        }

        if(isCapital(word.charAt(0))){
            if(isCapital(word.charAt(1))){
                boolean result = true;
                for(int i=2;i<word.length();i++){
                    if (!isCapital(word.charAt(i))){
                        return false;
                    }
                }
                return result;
            }else {
                boolean result = true;
                for(int i=2;i<word.length();i++){
                    if (isCapital(word.charAt(i))){
                        return false;
                    }
                }
                return result;
            }
        }else {
            boolean result = true;
            for(int i=1;i<word.length();i++){
                if (isCapital(word.charAt(i))){
                    return false;
                }
            }
            return result;
        }
    }

    private boolean isCapital(char c) {
        return c>='A' && c<='Z';
    }
}
