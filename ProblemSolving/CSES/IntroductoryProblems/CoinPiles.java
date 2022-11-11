package ProblemSolving.CSES.IntroductoryProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CoinPiles {

    static StringBuilder result = new StringBuilder();

    public static String solve(long x, long y) {
        if ((x + y) % 3 != 0)
            return "NO";
        else {
            long max = Math.max(x, y);
            long min = Math.min(x, y);

            x = max;
            y = min;

            if (x == y) return "YES";
            return (x % 2 == 0 && x / 2 == y) ? "YES" : "NO";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++)
            result.append(solve(scanner.nextInt(), scanner.nextInt()) + "\n");

        System.out.println(result);
    }

}
