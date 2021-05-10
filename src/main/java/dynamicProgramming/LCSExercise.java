package dynamicProgramming;

import java.util.LinkedList;

public class LCSExercise {

    public static int computeLCS(String x, String y, int len1, int len2) {
        int[][] table = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // FILL IN CODE

            }
        }

        // Print the longest common subsequence
        // printLCS(x, y, len1, len2, table);
        return table[len1][len2];
    }

    public static void printLCS(String x, String y, int len1, int len2, int[][] table) {
        LinkedList<Character> res = new LinkedList<>();
        int i = len1;
        int j = len2;
        // start from the bottom right corner
        while (i > 0 && j > 0) {
            // FILL IN CODE

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
