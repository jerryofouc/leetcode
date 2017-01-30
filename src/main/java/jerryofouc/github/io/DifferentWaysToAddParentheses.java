package jerryofouc.github.io;

import java.util.*;

/**
 * Created by xiaojiez on 1/27/17.
 */
public class DifferentWaysToAddParentheses {
    static class Tuple{
        public Tuple(int left, int right) {
            this.left = left;
            this.right = right;
        }

        int left;
        int right;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Tuple)) return false;

            Tuple tuple = (Tuple) o;

            if (left != tuple.left) return false;
            return right == tuple.right;
        }

        @Override
        public int hashCode() {
            int result = left;
            result = 31 * result + right;
            return result;
        }
    }

    public static List<Integer> diffWaysToCompute(String input) {
        String[] aa = input.split("\\+|-|\\*");

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < aa.length; i++) {
            list.add(Integer.parseInt(aa[i]));
        }

        List<Character> signList = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                signList.add(input.charAt(i));
            }
        }

        Map<Tuple, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            List<Integer> integerSet = new ArrayList<>();
            integerSet.add(list.get(i));
            map.put(new Tuple(i, 0), integerSet);
        }


        for (int i = 0; i < list.size() - 1; i++) {
            List<Integer> integerSet = new ArrayList<>();
            int result = -1;
            if (signList.get(i) == '+') {
                result = list.get(i) + list.get(i + 1);
            }
            if (signList.get(i) == '-') {
                result = list.get(i) - list.get(i + 1);
            }
            if (signList.get(i) == '*') {
                result = list.get(i) * list.get(i + 1);
            }

            integerSet.add(result);
            map.put(new Tuple(i, 1), integerSet);
        }


        for (int j = 2; j < list.size(); j++) {
            for (int i = 0; i < list.size() - j; i++) {
                List<Integer> result = new ArrayList<>();
                for (int t = 0; t < j; t++) {
                    List<Integer> left = map.get(new Tuple(i, t));
                    List<Integer> right = map.get(new Tuple(i + t + 1, j-t-1));
                    if (signList.get(i + t) == '+') {
                        for (Integer le : left) {
                            for (Integer ri : right) {
                                result.add(le + ri);
                            }
                        }

                    }
                    if (signList.get(i + t) == '-') {
                        for (Integer le : left) {
                            for (Integer ri : right) {
                                result.add(le - ri);
                            }
                        }
                    }
                    if (signList.get(i + t) == '*') {
                        for (Integer le : left) {
                            for (Integer ri : right) {
                                result.add(le * ri);
                            }
                        }
                    }
                    map.put(new Tuple(i, j), result);
                }
            }
        }
        return new ArrayList<>(map.get(new Tuple(0, list.size() - 1)));
    }

    public static void main(String[] args) {
        System.out.println(diffWaysToCompute("2*3-4*5"));
    }
}
