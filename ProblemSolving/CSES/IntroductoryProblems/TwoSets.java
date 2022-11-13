package ProblemSolving.CSES.IntroductoryProblems;

import java.util.Scanner;

public class TwoSets {

    static StringBuilder result = new StringBuilder();

    public static void solve(int n) {
        long sum = ((long) n * (n + 1)) >> 1;

        if (sum % 2 == 1) {
            result.append("NO");
            return;
        }

        long target = sum >> 1;
        long j = n, count;

        while (j <= target) {
            result.append(j + " ");
            target -= j;
            j--;
        }

        count = n - j;
        if (target > 0) {
            result.append(target+ "\n");
            count++;
        }
        result.insert(0, "YES\n" + count + "\n");
        result.append(n - count + "\n");

        for (int i = 1; i <= j; i++)
            if (i != target)
                result.append(i + " ");
    }

    public static void main(String[] args) {
        solve(new Scanner(System.in).nextInt());
        System.out.println(result);
    }

}
