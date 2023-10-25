package ProblemSolving.RandomProblems;

import java.util.Scanner;

public class BalancedParentheses {
    public static boolean solve(String parentheses) {
        int levelDetector = 0;

        for (int i = 0; i < parentheses.length(); i++) {
            if (parentheses.charAt(i) == '(')
                levelDetector++;
            else
                levelDetector--;

            if (levelDetector < 0)
                return false;
        }

        return levelDetector == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(solve(scanner.next()));
    }
}
