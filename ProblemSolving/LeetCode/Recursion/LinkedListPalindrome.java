package ProblemSolving.LeetCode.Recursion;

public class LinkedListPalindrome {

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    boolean isPalindrome = true;
    ListNode firstPointer;

    public ListNode reverse(ListNode node) {
        if(node.next == null)
            return node;

        ListNode secondPointer = reverse(node.next);

        if(firstPointer == null || firstPointer.val != secondPointer.val)
            isPalindrome = false;

        firstPointer = firstPointer.next;

        return node;
    }

    public boolean isPalindrome(ListNode head) {
        firstPointer = head;

        reverse(head);

        return isPalindrome;
    }

    public static void main(String[] args) {
        //Input Logic
    }

}
