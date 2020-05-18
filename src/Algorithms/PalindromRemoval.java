package Algorithms;

public class PalindromRemoval {
    public static int minimumMoves(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int len = arr.length;
        // dp[i][j] means minimum moves for subarray [i, j]
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        for (int j = 0; j < len; j++) {
            for (int i = j - 1; i >= 0; i--) {
                if (i == j - 1) {
                    dp[i][j] = arr[i] == arr[j] ? 1 : 2;
                    continue;
                }
                int min = Integer.MAX_VALUE;
                if (arr[i] == arr[j]) {
                    min = Math.min(min, dp[i + 1][j - 1]);
                }
                // two subarrays [i, k], and (k, j]
                for (int k = i; k < j; k++) {
                    min = Math.min(min, dp[i][k] + dp[k + 1][j]);
                }
                dp[i][j] = min;
            }
        }
        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,3,4,3,1,5};
        System.out.println(PalindromRemoval.minimumMoves(arr));
    }
}
