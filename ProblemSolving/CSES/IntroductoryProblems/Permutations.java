package ProblemSolving.CSES.IntroductoryProblems;

import java.util.Scanner;

public class Permutations {

    static void solve(int n) {
        StringBuilder permutation = new StringBuilder();

        if (n < 4 && n > 1) {
            System.out.println("NO SOLUTION");
            return;
        }

        for (int i = 2; i <= n; i += 2)
            permutation.append(i + " ");


        for (int i = 1; i <= n; i += 2)
            permutation.append(i + " ");

        System.out.println(permutation);
    }

    public static void main(String[] args) {
        solve(new Scanner(System.in).nextInt());
    }

}
