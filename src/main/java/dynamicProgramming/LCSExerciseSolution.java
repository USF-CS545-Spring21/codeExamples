package dynamicProgramming;

import java.util.LinkedList;

public class LCSExerciseSolution {
    public static int computeLCS(String x, String y, int len1, int len2) {
        int[][] table = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) { // last character is the same
                    table[i][j] = table[i - 1][j - 1] + 1;
                } else {
                    int lcs1 = table[i - 1][j];
                    int lcs2 = table[i][j - 1];
                    if (lcs1 >= lcs2) {
                        table[i][j] = lcs1;
                    } else
                        table[i][j] = lcs2;
                }
            }
        }

        printLCS(x, y, len1, len2, table);
        return table[len1][len2];
    }

    public static void printLCS(String x, String y, int len1, int len2, int[][] table) {
        LinkedList<Character> res = new LinkedList<>();
        int i = len1;
        int j = len2;
        // start from the bottom right corner
        while (i > 0 && j > 0) {
            if (x.charAt(i-1) == y.charAt(j-1)) {
                res.addFirst(x.charAt(i-1));
                i--;
                j--;
                if (table[i][j] == 0) {
                    System.out.println(res);
                    return;
                }
            }
            else {
                int lcs1 = table[i-1][j];
                int lcs2 = table[i][j-1];
                if (lcs1 >= lcs2) {
                    i--;
                }
                else
                    j--;
            }
        }
    }

    public static void main(String[] args) {
        String x = "BDCABA";
        int len1 = 6;
        String y = "ABCBDAB";
        int len2 = 7;
        System.out.println(computeLCS(x, y, len1, len2));
    }
}
