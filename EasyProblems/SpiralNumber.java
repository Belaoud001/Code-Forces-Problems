import java.util.Scanner;

public class SpiralNumber {
    static StringBuilder result = new StringBuilder();

    public static void solve(int y, int x) {
        long number;

        if (x < y)
            if (y % 2 == 0)
                number = (long) y * y - x + 1;
            else
                number = (long) (y - 1) * (y - 1) + 1 + x - 1;
        else
            if (x % 2 == 0)
                number = (long) (x - 1) * (x - 1) + 1 + y - 1;
            else
                number = (long) x * x - y + 1;

        result.append(number).append("\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++)
            solve(scanner.nextInt(), scanner.nextInt());

        System.out.println(result);
    }

}
