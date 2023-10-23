package ProblemSolving.CSES.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class MinimizingCoins {

    public static long solve(int[] coins, int target) {
        int[] dp = new int[target + 1];

        Arrays.fill(dp, Integer.MAX_VALUE - 1);

        dp[0] = 0;
        for (int i = 0; i <= target; i++)
            for (int j = 0; j < coins.length; j++) {
                int subTarget = i - coins[j];

                if (subTarget < 0) continue;

                dp[i] = Math.min(dp[i], dp[subTarget] + 1);
            }

        return dp[target] == Integer.MAX_VALUE - 1 ? -1 : dp[target];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] totalAndTarget = Arrays.stream(scanner.nextLine()
                                                    .split(" "))
                                                    .mapToInt(Integer::parseInt)
                                                    .toArray();
        int[] coins = Arrays.stream(scanner.nextLine()
                                           .split(" "))
                                           .mapToInt(Integer::parseInt)
                                           .toArray();

        System.out.println(solve(coins, totalAndTarget[1]));
    }

}
