package ProblemSolving.CSES.SortingAndSearching;

import java.util.*;
import java.util.stream.Collectors;

public class DistinctNumbers {

    public static int solve(List<Integer> numbers) {
        return new HashSet<>(numbers).size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                                                                .map(Integer::parseInt)
                                                                .collect(Collectors.toList());

        System.out.println(solve(numbers));
    }

}
