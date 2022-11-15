package ProblemSolving.LeetCode.TwoPointers;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        for (int j = 0, i = 0; j < nums.length; j++)
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j] = temp;
            }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {0, 1, 0, 3, 12};
        moveZeroes(arr);

        //1 3 12 0 0
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
