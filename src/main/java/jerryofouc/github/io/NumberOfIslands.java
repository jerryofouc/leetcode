package jerryofouc.github.io;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by xiaojiez on 1/21/17.
 */
public class NumberOfIslands {

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

    public static int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        char[][] gridNew = new char[grid.length + 2][grid[0].length + 2];
        for (int i = 0; i < gridNew.length; i++) {
            for (int j = 0; j < gridNew[0].length; j++) {
                if (i == 0 || j == 0 || i==gridNew.length-1||j==gridNew[0].length-1) {
                    gridNew[i][j] = '0';
                }else {
                    gridNew[i][j] = grid[i-1][j-1];
                }
            }
        }

        Set<Tuple> set = new HashSet<Tuple>();
        Stack<Tuple> stack = new Stack<Tuple>();
        int result = 0;

        for (int i = 1; i < grid.length+1; i++) {
            for (int j = 1; j < grid[0].length+1; j++) {
                if (gridNew[i][j] != '0'&&!set.contains(new Tuple(i,j))) {
                    result++;
                    stack.push(new Tuple(i, j));
                    set.add(new Tuple(i, j));


                    while (!stack.isEmpty()) {
                        Tuple tuple = stack.pop();
                        if (gridNew[tuple.left][tuple.right + 1] != '0' && !set.contains(new Tuple(tuple.left, tuple.right + 1))) {
                            set.add(new Tuple(tuple.left, tuple.right + 1));
                            stack.push(new Tuple(tuple.left, tuple.right + 1));
                        }
                        if (gridNew[tuple.left + 1][tuple.right] != '0' && !set.contains(new Tuple(tuple.left + 1, tuple.right))) {
                            set.add(new Tuple(tuple.left + 1, tuple.right));
                            stack.push(new Tuple(tuple.left + 1, tuple.right));
                        }
                        if (gridNew[tuple.left - 1][tuple.right] != '0' && !set.contains(new Tuple(tuple.left - 1, tuple.right))) {
                            set.add(new Tuple(tuple.left - 1, tuple.right));
                            stack.push(new Tuple(tuple.left - 1, tuple.right));
                        }
                        if (gridNew[tuple.left][tuple.right - 1] != '0' && !set.contains(new Tuple(tuple.left, tuple.right - 1))) {
                            set.add(new Tuple(tuple.left, tuple.right - 1));
                            stack.push(new Tuple(tuple.left, tuple.right - 1));
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] nums = new char[][]{
                {'1'}
        };

        System.out.println(numIslands(nums));
    }

}
