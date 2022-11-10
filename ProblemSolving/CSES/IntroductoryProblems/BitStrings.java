package ProblemSolving.CSES.IntroductoryProblems;

import java.math.BigInteger;
import java.util.Scanner;

public class BitStrings {

    public static BigInteger solve(int n) {
        BigInteger modulo = new BigInteger(String.valueOf(10)).pow(9).add(BigInteger.valueOf(7));
        return new BigInteger(String.valueOf(2)).pow(n).mod(modulo);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solve(scanner.nextInt()));
    }

}
