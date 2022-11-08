package EasyProblems;

import java.util.Scanner;

public class ThirdThreeNumber {

    public static void solve(int number) {
        if (number % 2 == 0)
            System.out.println(number / 2 + " " + number / 2 + " 0");
        else
            System.out.println(-1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();

        for (int i = 0; i < tests; i++)
            ThirdThreeNumber.solve(scanner.nextInt());
    }

}
