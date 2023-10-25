package ProblemSolving.RandomProblems;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class DisjointIntervals {
    public static int solve(ArrayList<ArrayList<Integer>> intervals) {
        intervals.sort(comparing(o -> o.get(0)));

        int max = Integer.MIN_VALUE;
        int counter = 0;
        for (int i = 1; i < intervals.size(); i++) {

            if (intervals.get(i).get(1) < intervals.get(i - 1).get(1)) {
                max = Math.max(max, counter);
                counter = 0;
            }

            counter++;
        }

        return counter;
    }

    public static int solve2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        int max = Integer.MIN_VALUE;
        int counter = 0;
        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] < intervals[i - 1][0]) {
                max = Math.max(max, counter);
                counter = 0;
            }

            counter++;
        }

        return counter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> intervals = new ArrayList<>();
        int numberOfTests = scanner.nextInt();

        scanner.nextLine();

        for (int i = 0; i < numberOfTests; i++) {
            String input = scanner.nextLine();
            ArrayList interval = (ArrayList) Arrays.stream(input.split(" "))
                                                                .map(Integer::parseInt)
                                                                .collect(Collectors.toList());
            intervals.add(interval);
        }
    }
}
