package ProblemSolving.LeetCode.CountingSort;

import java.util.*;

public class SortAnArray {

    public static int[] sortArray(int[] nums) {
        Map<Integer, Integer> numbers = new HashMap<>();
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            numbers.merge(nums[i], 1, Integer::sum);
            maxValue = Math.max(maxValue, nums[i]);
            minValue = Math.min(minValue, nums[i]);
        }

        int k = 0;
        for (int i = minValue; i <= maxValue; i++) {
            System.out.println("i = " + i);
            for (int j = 0; j < numbers.getOrDefault(i, 0); j++)
                nums[k++] = i;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-4, 0, 7, 4, 9, -5, -1, 0, -7, -1};

        arr = sortArray(arr);

        //result as expect.. ofc using other sorting algos would be faster... but its countingSort package !
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }
}
