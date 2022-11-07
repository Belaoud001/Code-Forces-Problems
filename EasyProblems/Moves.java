package EasyProblems;

import java.util.Scanner;

public class Moves {

    public static int solve(int coordinates) {
        if(coordinates % 3 == 0)
            return coordinates / 3;
        if(coordinates % 3 == 2)
            return coordinates / 3 + 1;
        else
            return (coordinates - 3) / 3 + 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();

        for(int i = 0; i < tests; i++)
            System.out.println(Moves.solve(scanner.nextInt()));
    }

}
