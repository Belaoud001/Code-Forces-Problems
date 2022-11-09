package ProblemSolving.CodingForces;

import java.util.Scanner;

public class BanBan {

    static StringBuilder result = new StringBuilder();

    public static void solve(int n) {
        int i = 1;
        int j = n * 3;

        result.append((n + 1) / 2 + "\n");

        while (i < j) {
            result.append(i + " " + j + "\n");
            i += 3;
            j -= 3;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++)
            solve(scanner.nextInt());

        System.out.println(result);
    }

}
