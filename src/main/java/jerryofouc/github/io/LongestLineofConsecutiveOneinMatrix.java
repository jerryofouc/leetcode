package jerryofouc.github.io;

/**
 * Created by xiaojiez on 4/23/17.
 */
public class LongestLineofConsecutiveOneinMatrix {
    public static int longestLine(int[][] M) {
        if (M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < M.length; i++) {
            int sum = 0;
            for (int j = 0; j < M[0].length; j++) {
                if (i < M.length && j < M[0].length) {
                    if (M[i][j] == 0) {
                        sum = 0;
                    } else {
                        sum++;
                        max = Math.max(sum, max);
                    }
                }
            }
        }

        for (int i = 0; i < M[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < M.length; j++) {
                if (i < M[0].length && j < M.length) {
                    if (M[j][i] == 0) {
                        sum = 0;
                    } else {
                        sum++;
                        max = Math.max(sum, max);
                    }
                }
            }
        }


        for (int start = 0; start < M[0].length; start++) {
            int sum = 0;
            int i = 0;
            int j = start;
            while (i < M.length && j < M[0].length) {
                if (M[i][j] == 0) {
                    sum = 0;
                } else {
                    sum++;
                    max = Math.max(sum, max);
                }

                i++;
                j++;
            }
        }

        for (int start = 0; start < M.length; start++) {
            int sum = 0;
            int i = start;
            int j = 0;
            while (i < M.length && j < M[0].length) {
                if (M[i][j] == 0) {
                    sum = 0;
                } else {
                    sum++;
                    max = Math.max(sum, max);
                }

                i++;
                j++;
            }
        }

        for (int start = 0; start < M[0].length; start++) {
            int sum = 0;
            int i = 0;
            int j = start;
            while (i < M.length && j >= 0) {
                if (i < M.length && j >= 0) {
                    if (M[i][j] == 0) {
                        sum = 0;
                    } else {
                        sum++;
                        max = Math.max(sum, max);
                    }
                }
                i++;
                j--;
            }
        }

        for (int start = 0; start < M.length; start++) {
            int sum = 0;
            int i = start;
            int j = M[0].length-1;
            while (i < M.length && j >= 0) {
                if (i < M.length && j >= 0) {
                    if (M[i][j] == 0) {
                        sum = 0;
                    } else {
                        sum++;
                        max = Math.max(sum, max);
                    }
                }
                i++;
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] M = {
                {0, 1, 0},
                {0, 1, 0},
                {0, 1, 0},
                {0, 1, 0},
                {0, 1, 0},
        };
        System.out.println(longestLine(M));

        System.out.println((Long.MAX_VALUE+"").length());
    }
}
