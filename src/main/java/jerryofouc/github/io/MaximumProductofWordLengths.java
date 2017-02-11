package jerryofouc.github.io;

import java.util.HashSet;

/**
 * Created by xiaojiez on 2/11/17.
 */
public class MaximumProductofWordLengths {
    public static int maxProduct(String[] words) {
        HashSet<Integer>[] wordSet = new HashSet[26];
        for(int i=0;i<words.length;i++){
            for(char c : words[i].toCharArray()){
                if(wordSet[c-'a'] == null){
                    wordSet[c-'a'] = new HashSet<>();
                }
                wordSet[c-'a'].add(i);
            }
        }

        int max = 0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if(notCommon(i,j,wordSet)){
                    int l = words[i].length()*words[j].length();
                    if(max < l){
                        max = l;
                    }
                }
            }
        }
        return max;

    }

    private static boolean notCommon(int i, int j, HashSet<Integer>[] wordSet) {
        boolean isNotCommont = true;
        for(int k=0;k<26;k++){
            if(wordSet[k] != null && wordSet[k].contains(i) && wordSet[k].contains(j)){
                isNotCommont = false;
                break;
            }
        }
        return isNotCommont;
    }

    public static void main(String[] args) {
        String[] aa = new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println(maxProduct(aa));
    }
}
