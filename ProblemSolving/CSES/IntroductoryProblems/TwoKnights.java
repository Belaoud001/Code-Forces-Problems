package ProblemSolving.CSES.IntroductoryProblems;

import java.util.Scanner;

public class TwoKnights {

    static StringBuilder result = new StringBuilder();

    private static void solve(int n) {
        long totalCombination   = (long) n * n * ((long) n * n - 1) >> 1;
        long confrontationCases = 4L * (n - 1) * (n - 2);
        long possibleWays = totalCombination - confrontationCases;

        result.append(possibleWays + "\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++)
            solve(i);

        System.out.println(result);
    }

}
