package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaojiez on 3/22/17.
 */
public class ZumaGame {
    public static int findMinStep(String board, String hand) {
        int result = 0;
        Map<Character, Integer> handMap = new HashMap<>();
        for (int i = 0; i < hand.length(); i++) {
            Integer num = handMap.getOrDefault(hand.charAt(i), 0);
            handMap.put(hand.charAt(i), ++num);
        }
        List<Character> moreThanTwos = new ArrayList<>();
        for (Character c : handMap.keySet()) {
            if (handMap.getOrDefault(c, 0) >= 1) {
                moreThanTwos.add(c);
            }
        }

        if (moreThanTwos.size() == 0) {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        for (Character c : moreThanTwos) {
            for (int i = 0; i < board.length(); i++) {
                if (board.charAt(i) == c.charValue()) {
                    int j = i + 1;
                    for (; j < board.length() && board.charAt(j) == c.charValue(); ) {
                        j++;
                    }
                    int num = handMap.get(c);
                    if (num + j - i >= 3) {
                        String nextHand = getNextHand(handMap, c, 3 - (j - i));
                        String nextBoard = board.substring(0, i) + (j == board.length() ? "" : board.substring(j));
                        nextBoard = slim(nextBoard);
                        if (nextBoard.length() == 0) {
                            if (min > 3 - (j - i)) {
                                min = 3 - (j - i);
                            }
                        } else {
                            int cur = findMinStep(nextBoard
                                    , nextHand);
                            if (cur != -1) {
                                if (min > cur + 3 - (j - i)) {
                                    min = cur + 3 - (j - i);
                                }
                            }
                        }
                    }

                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            return -1;
        }

        return result + min;
    }

    private static String getNextHand(Map<Character, Integer> handMap, Character c, int d) {
        String ret = "";
        for (Map.Entry<Character, Integer> entry : handMap.entrySet()) {
            if (entry.getKey().equals(c)) {
                for (int i = 0; i < entry.getValue() - d; i++) {
                    ret += entry.getKey();
                }
            } else {
                for (int i = 0; i < entry.getValue(); i++) {
                    ret += entry.getKey();
                }
            }
        }
        return ret;
    }

    private static String slim(String newResult) {
        int num = 1;
        for (int j = 1; j < newResult.length(); j++) {
            if (newResult.charAt(j) == newResult.charAt(j - 1)) {
                num++;
            } else {
                if (num >= 3) {
                    String a = newResult.substring(0, j - num) + newResult.substring(j);
                    return slim(a);
                } else {
                    num = 1;
                }
            }
        }

        if (num >= 3) {
            String a = newResult.substring(0, newResult.length() - num);
            return slim(a);
        }
        return newResult;
    }

    public static void main(String[] args) {
        //  System.out.println(slim("WWW"));
        case1();
        case2();
        case3();
        case4();
        case5();
        case6();
        case7();
    }

    static void case1() {
        System.out.println(findMinStep("WRRBBW", "RB"));
    }

    static void case2() {
        System.out.println(findMinStep("WWRRBBWW", "WRBRW"));
    }

    static void case3() {
        System.out.println(findMinStep("G", "GGGGG"));

    }

    static void case4() {
        System.out.println(findMinStep("RBYYBBRRB", "YRBGB"));
    }

    static void case5() {
        System.out.println(findMinStep("RRWWRRW", "RR"));
    }

    static void case6() {
        System.out.println(findMinStep("RWYWRRWRR", "YRY"));
    }

    static void case7() {
        System.out.println(findMinStep("RGGBYRRYWWYYBBGRGG", "RRYWG"));
    }


}
