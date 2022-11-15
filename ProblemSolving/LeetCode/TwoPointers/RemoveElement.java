package ProblemSolving.LeetCode.TwoPointers;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int i = 0, counter = 0, end = nums.length - 1;

        while(i <= end) {
            if(nums[i] == val) {
                int temp = nums[end];
                nums[end--] = val;
                nums[i] = temp;
                counter++;
            } else
                i++;
        }

        return nums.length - counter;
    }

    public static void main(String[] args) {
        //Input Logic
    }

}
