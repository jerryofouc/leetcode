package jerryofouc.github.io;

import java.util.*;

/**
 * Created by xiaojiezhang on 1/3/17.
 */
public class SubstringWithConcatenationOfAllWords {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        if (words.length == 0) {
            return new ArrayList<Integer>();
        }

        int wordLength = words[0].length();
        if (s.length() < wordLength) {
            return new ArrayList<Integer>();
        }
        Map<String, Integer> wordMap = new HashMap<String, Integer>();
        for (String w : words) {
            Integer i = wordMap.get(w);
            if (i == null) {
                wordMap.put(w, 1);
            } else {
                wordMap.put(w, i + 1);
            }
        }

        for (int iStart = 0; iStart < wordLength; iStart++) {
            int left = iStart;
            Map<String, Integer> kMap = new HashMap<String, Integer>();
            for (String w : words) {
                kMap.put(w, 0);
            }
            int count = 0;
            int j = left;
            for (; j + wordLength <= s.length(); ) {
                String subWord = s.substring(j, j + wordLength);
                Integer wordMapCount = wordMap.get(subWord);
                if (wordMapCount == null) {
                    kMap.clear();
                    left = j + wordLength;
                    j = j + wordLength;
                    count = 0;
                } else {
                    Integer kMapCount = (kMap.get(subWord)==null?0:kMap.get(subWord));
                    if (kMapCount < wordMapCount) {
                        kMap.put(subWord, kMapCount + 1);
                        j += wordLength;
                        count++;
                        if (count == words.length) {
                            result.add(left);
                            count--;
                            kMap.put(s.substring(left, left + wordLength), (kMap.get((s.substring(left, left + wordLength)))==null?0:kMap.get((s.substring(left, left + wordLength)))) - 1);
                            left = left + wordLength;
                        }
                    } else {
                        while ((kMap.get(subWord)==null?0:kMap.get(subWord)) >= wordMap.get(subWord)) {
                            String leftWord = s.substring(left, left + wordLength);
                            kMap.put(leftWord, (kMap.get(leftWord)==null?0:kMap.get(leftWord)) - 1);
                            left += wordLength;
                            count--;
                        }
                        count++;
                        kMap.put(subWord, (kMap.get(subWord)==null?0:kMap.get(subWord)) + 1);
                        j += wordLength;
                    }
                }

            }


        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
    }
}
