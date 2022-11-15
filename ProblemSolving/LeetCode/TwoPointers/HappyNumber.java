package ProblemSolving.LeetCode.TwoPointers;

import java.util.Scanner;

public class HappyNumber {

    public static int sumOfSquares(int n) {
        int sum = 0;

        while(n != 0) {
            int digit = n % 10;
            sum += Math.pow(digit, 2);
            n /= 10;
        }

        return sum;
    }

    public static boolean isHappy(int n) {
        int slow = sumOfSquares(n);
        int fast = sumOfSquares(slow);

        while(slow != fast) {
            if(slow == 1 || fast == 1)
                return true;

            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        }

        return slow == 1;

    }

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        boolean isHappy = isHappy(n);
        System.out.println("is " + n + " happy ? " + isHappy);
    }

}
