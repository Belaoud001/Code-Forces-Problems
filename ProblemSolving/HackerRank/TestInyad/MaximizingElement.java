package ProblemSolving.HackerRank.TestInyad;

import java.util.ArrayList;
import java.util.List;

public class MaximizingElement {

    public static int solve(List<Integer> numbers) {
        int[] helper = new int[100001];
        int length = numbers.size();
        int maxElement = Integer.MIN_VALUE;

        for (int i = 0; i < length; i++) {
            helper[numbers.get(i)]++;
            maxElement = Math.max(maxElement, numbers.get(i));
        }

        int max = 0;

        for (int i = 1; i <= maxElement; i++) {
            if (helper[i] > 0) {
                if (helper[i] >= i - max)
                    max = i;
                else
                    max += helper[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(){{
            add(1);
            add(5);
            add(5);
            add(10001);
        }};

        System.out.println(solve(numbers));
    }

}
