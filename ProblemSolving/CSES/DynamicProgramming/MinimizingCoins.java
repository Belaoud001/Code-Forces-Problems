package ProblemSolving.CSES.DynamicProgramming;

import java.util.Arrays;

public class MinimizingCoins {

    public static int solve(int[] coins, int target) {
        int[] dp = new int[target + 1];

        Arrays.fill(dp, Integer.MAX_VALUE - 1);

        dp[0] = 0;
        for (int i = 0; i <= target; i++)
            for (int j = 0; j < coins.length; j++) {
                int subTarget = i - coins[j];

                if (subTarget < 0) continue;

                dp[i] = Math.min(dp[i], dp[subTarget] + 1);
            }

        return dp[target];
    }


    public static void main(String[] args) {
        int[] coinsSet = new int[] {1, 5, 7};
        int target = 11;

        System.out.println(solve(coinsSet, target)); // output : 3 (simply : 5 * 2 + 1)
    }

}
