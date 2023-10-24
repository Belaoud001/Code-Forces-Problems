package ProblemSolving.RandomProblems;

import java.util.Scanner;

// In this problem we are allowed to make a string that contain one type of parentheses as input.
public class BalancedParentheses {
    public static boolean solve(String parentheses) {
        // Here we are at the balanced state
        int levelDetector = 0;

        for (int i = 0; i < parentheses.length(); i++) {
            if (levelDetector < 0)
                return false;

            if (parentheses.charAt(i) == '(')
                levelDetector++;
            else
                levelDetector--;
        }

        // We must always head to the balanced state.
        return levelDetector == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(solve(scanner.next()));
    }
}
