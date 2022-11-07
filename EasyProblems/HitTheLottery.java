package EasyProblems;

import java.util.Scanner;

public class HitTheLottery {

    public static int solve(int dollars) {
        int[] denominations = new int[]{100, 20, 10, 5, 1};
        int result = 0;

        for(int i = 0; i < 5; i++) {
            if(dollars == 0) break;
            result += dollars / denominations[i];
            dollars %= denominations[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(HitTheLottery.solve(scanner.nextInt()));
    }

}
