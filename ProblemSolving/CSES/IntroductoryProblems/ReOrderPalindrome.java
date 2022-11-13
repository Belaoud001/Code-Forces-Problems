package ProblemSolving.CSES.IntroductoryProblems;

import java.util.Scanner;

public class ReOrderPalindrome {

    static int[] alphabets = new int[28];
    static char[] palindrome;

    public static String solve(String string) {
        for (int i = 0; i < string.length(); i++)
            alphabets[string.charAt(i) % 65]++;

        boolean midFound = false;
        int start = 0, end = string.length() - 1;
        for (int i = 0; i < 28; i++) {
            if (alphabets[i] != 0) {
                if (alphabets[i] == 1) {
                    if (midFound || string.length() % 2 == 0)
                        return "NO SOLUTION";
                    palindrome[string.length() / 2] = (char) (65 + i);
                    midFound = true;
                    continue;
                }
                if (alphabets[i] % 2 == 0) {
                    for (int j = 0; j < alphabets[i] / 2; j++) {
                        palindrome[start++] = (char) (65 + i);
                        palindrome[end--]   = (char) (65 + i);
                    }
                } else {
                    if (midFound || string.length() % 2 == 0)
                        return "NO SOLUTION";

                    int middle = string.length() / 2;
                    palindrome[middle] = (char) (65 + i);

                    for (int j = 1; j <= alphabets[i] / 2; j++) {
                        palindrome[middle - j] = (char) (65 + i);
                        palindrome[middle + j] = (char) (65 + i);
                    }
                    midFound = true;
                }
            }
        }

        return "";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        palindrome = new char[input.length()];
        String solution = solve(input);

        if (solution.length() == 0)
            System.out.println(new String(palindrome));
        else
            System.out.println(solution);
    }

}
