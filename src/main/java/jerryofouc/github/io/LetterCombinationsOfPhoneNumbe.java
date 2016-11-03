package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaojiezhang on 11/3/16.
 */
public class LetterCombinationsOfPhoneNumbe {
    public static List<String> letterCombinations(String digits) {
        if(digits == null || digits.length()==0){
            return new ArrayList<String>();
        }
        Map<Character,Character[]> digitalStringMap =
                new HashMap<Character, Character[]>();
        digitalStringMap.put('2',new Character[]{'a','b','c'});
        digitalStringMap.put('3',new Character[]{'d','e','f'});
        digitalStringMap.put('4',new Character[]{'g','h','i'});
        digitalStringMap.put('5',new Character[]{'j','k','l'});
        digitalStringMap.put('6',new Character[]{'m','n','o'});
        digitalStringMap.put('7',new Character[]{'p','q','r','s'});
        digitalStringMap.put('8',new Character[]{'t','u','v'});
        digitalStringMap.put('9',new Character[]{'w','x','y','z'});

        char[] digitChar = digits.toCharArray();
        return getString(digitalStringMap,digitChar,digitChar.length-1);
    }

    private static List<String> getString(Map<Character,Character[]> digitalStringMap,char[] digitChar, int k) {
        if(k ==-1){
            List<String> result =  new ArrayList<String>();
            result.add("");
            return result;
        }else {
            List<String> result = getString(digitalStringMap,digitChar,k-1);
            List<String> retVal = new ArrayList<String>();
            for(Character c : digitalStringMap.get(digitChar[k])){
                for(String r : result){
                    retVal.add(r+c);
                }
            }
            return retVal;
        }

    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
