package ProblemSolving.LeetCode.TwoPointers;

public class RemoveDuplicates1 {

    public static int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                continue;
            }
            nums[count] = nums[i];
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 1, 2, 3, 3, 4, 8};

        System.out.println(removeDuplicates(arr));//5
    }
}
