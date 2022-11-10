package ProblemSolving.CSES.IntroductoryProblems;

import java.util.Scanner;

public class TrailingZeros {

    public static int solve(long number) {
        int count = 0, divisor = 5;

        while (divisor <= number) {
            count += number / divisor;
            divisor *= 5;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(solve(scanner.nextInt()));
    }

}
