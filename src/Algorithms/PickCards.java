package Algorithms;

import java.util.Arrays;

/**
 * @author skuang
 */
public class PickCards {
    public boolean pickCards(int[] cards) {
        int[] dp = new int[cards.length + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[cards.length] = 0;
        for (int i = cards.length - 1; i >= 0; i--) {
            int sum = 0;
            for (int j = i; j >= 0 && j >= i - 2; j--) {
                sum += cards[j];
                dp[j] = Math.max(dp[j], sum - dp[i + 1]);
            }
        }
        System.out.println(Arrays.toString(dp));
        if (dp[0] > 0) return true;
        else if (dp.length > 1 && dp[1] > 0) return true;
        else if (dp.length > 2 && dp[2] > 0) return true;
        return false;
    }

    public static void main(String[] args) {
        PickCards sol = new PickCards();
        System.out.println(sol.pickCards(new int[] {100, 1, -1, 2, 200, 1}));
    }
}
