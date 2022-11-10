package ProblemSolving.Utils;


public class Maths {

    public static long factorial(int n) {
        if (n == 0 || n == 1)
            return 1;

        long result = 1;
        for (int i = 2; i <= n; i++)
            result *= i;

        return result;
    }

    public static long nCr(final int n, final int r) {
        long dividend = factorial(n);
        long divisor  = factorial(r) * factorial(n - r);

        return dividend / divisor;
    }

}
