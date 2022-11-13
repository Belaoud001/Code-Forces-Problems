package ProblemSolving.CSES.IntroductoryProblems;

import java.util.Scanner;

public class CoinPiles {

    static StringBuilder result = new StringBuilder();

    public static String solve(long x, long y) {
        if ((x + y != 0 && (x == 0 || y == 0)) || (x + y) % 3 != 0)
            return "NO";

        if (x == y)
            return "YES";
        while (true) {
            long temp = ((x + y) * 2) / 3;
            x = Math.max(x, y);

            if (x == temp)
                return "YES";
            if (x > temp)
                return "NO";

            x = temp - x;
            y = x * 2;
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
