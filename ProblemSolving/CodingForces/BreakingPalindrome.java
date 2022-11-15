package ProblemSolving.CodingForces;

import java.util.Scanner;

public class BreakingPalindrome {

    public static String solve(String input) {
        StringBuilder palindrome = new StringBuilder(input);
        boolean isPossible = false;
        int i = 0;

        if (palindrome.length() == 1)
            return "";

        for (; i < palindrome.length() / 2; i++)
            if (palindrome.charAt(i) != 'a') {
                palindrome.setCharAt(i, 'a');
                isPossible = true;
                break;
            }

        if (!isPossible)
            palindrome.setCharAt(palindrome.length() - 1, 'b');

        return palindrome.toString();
    }

    public static void main(String[] args) {
        System.out.println(solve(new Scanner(System.in).next()));
    }

}
