package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/11/17.
 */
public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int max = 0;
        for (char i = 'A'; i <= 'Z'; i++) {
            int t = 0, j = 0;
            for (; j < s.length(); j++) {
                if (s.charAt(j) == i) {

                } else {
                    if (t == k) {
                        break;
                    }
                    t++;
                }
            }
            int last = j;
            if (max < last) {
                max = last;
            }
            for (j = 1; j < s.length(); j++) {
                int cur = 0;
                if (k != 0) {
                    cur = last;
                }

                if (k != 0) {
                    cur--;
                }

                if (j + last - 1 < s.length()) {
                    int ii = j + last - 1;
                    while (ii < s.length() && s.charAt(ii) == i) {
                        cur++;
                        ii++;
                    }
                    if (s.charAt(j - 1) != i && ii < s.length() && k != 0) {
                        cur++;
                        ii++;
                        while (ii < s.length() && s.charAt(ii) == i) {
                            cur++;
                            ii++;
                        }
                    }
                    if (max < cur) {
                        max = cur;
                    }
                } else {
                    break;
                }
                last = cur;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("SDSSMESSTR", 2));
    }


}
