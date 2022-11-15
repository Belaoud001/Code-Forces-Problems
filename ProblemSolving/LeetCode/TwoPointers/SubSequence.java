package ProblemSolving.LeetCode.TwoPointers;

import java.util.Scanner;

public class SubSequence {

    public static boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;

        while(i < t.length() && j < s.length()) {
            if(t.charAt(i) == s.charAt(j))
                j++;
            i++;
        }

        return j == s.length();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string   = scanner.next();
        String subsequence = scanner.next();

        System.out.println("is a subsequence ?? " + isSubsequence(string, subsequence));
    }

}
