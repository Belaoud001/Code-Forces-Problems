package ProblemSolving.CSES.IntroductoryProblems;

import java.util.Scanner;

public class WeirdAlgorithm {

    static StringBuilder result = new StringBuilder();

    public static void solve(long n) {
        while (n != 1) {
            result.append(n + " ");
            n = ((n & 1) == 0) ? n >> 1 : n * 3 + 1;
        }

        result.append(1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        solve(scanner.nextInt());
        System.out.println(result);
    }

}
