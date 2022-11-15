package ProblemSolving.LeetCode.TwoPointers;

public class SortColors {

    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int i = 0;

        while(i <= end) {
            if(nums[i] == 0) {
                int temp = nums[start];

                nums[i] = temp;
                nums[start] = 0;
                start++;
                i++;
            } else if (nums[i] == 2) {
                int temp = nums[end];

                nums[i] = temp;
                nums[end] = 2;
                end--;
            } else
                i++;
        }

        System.out.println(nums);
    }

    public static void main(String[] args) {
        //Input Logic
    }

}
