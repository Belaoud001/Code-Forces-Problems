package ProblemSolving.HackerRank.TestOcto;

import java.util.Scanner;

public class EscapedCharacters {

    public static int escapedCharacters(int start, int end, String expression) {
        int counter = 0;

        while (start <= end) {
            if (Character.isLowerCase(expression.charAt(start)) && expression.charAt(start - 1) == '!')
                counter++;
            start++;
        }

        return counter;
    }

    public static int calculateEscapedCharacters(String expression) {
        int counter = 0, start = 0;
        int length = expression.length();
        boolean isEnd = false;

        for (int i = 0; i < length; i++)
            if (expression.charAt(i) == '#') {
                if (!isEnd) {
                    isEnd = true;
                    start = i++;
                    continue;
                }
                isEnd = false;
                counter += escapedCharacters(start, i, expression);
            }

        return  counter;
    }

    public static void main(String[] args) {
        System.out.println(calculateEscapedCharacters(new Scanner(System.in).next()));
    }

}
