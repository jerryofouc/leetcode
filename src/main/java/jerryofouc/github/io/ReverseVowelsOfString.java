package jerryofouc.github.io;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangxiaojie on 5/30/16.
 */
public class ReverseVowelsOfString {
    public static String reverseVowels(String s) {
        char[] letters = s.toCharArray();
        Set<Character>  vowelSet = new HashSet<Character>();
        vowelSet.add('a');
        vowelSet.add('A');
        vowelSet.add('e');
        vowelSet.add('E');
        vowelSet.add('i');
        vowelSet.add('I');
        vowelSet.add('o');
        vowelSet.add('O');
        vowelSet.add('u');
        vowelSet.add('U');

        int start = 0;
        int end = letters.length-1;
        int direction = 0;

        while (start<end){
            if(direction == 0){
                if(!vowelSet.contains(letters[start])){
                    start++;
                }else {
                    direction = 1;
                }
            }else {
                if(vowelSet.contains(letters[end])){
                    char temp = letters[start];
                    letters[start] = letters[end];
                    letters[end] = temp;
                    direction = 0;
                    start++;
                }
                end--;
            }
        }

        return new String(letters);

    }
    public static void main(String[] args) {
        System.out.println(reverseVowels("Aa"));
    }
}
