package ProblemSolving.LeetCode.TwoPointers;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int end = nums.length - 1;
        int i = 0;
        int counter = 0;

        while(i <= end) {
            if(nums[i] == val) {
                counter++;

                int temp = nums[end];

                nums[end] = val;
                nums[i] = temp;
                end--;
            } else {
                i++;
            }
        }

        return nums.length - counter;
    }

    public static void main(String[] args) {
        //Input Logic
    }

}
