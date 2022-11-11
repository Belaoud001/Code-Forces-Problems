package ProblemSolving.CSES.IntroductoryProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MissingNumber {

    static List<Long> numbers = new ArrayList<>();

    public static long solve(int n) {
        long expectedSum = ((long) n * (n + 1) / 2);
        long currentSum  = numbers.stream().reduce(0L, (a, b) -> a + b);
        return expectedSum - currentSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n - 1; i++)
            numbers.add(scanner.nextLong());

        System.out.println(solve(n));
    }

}
