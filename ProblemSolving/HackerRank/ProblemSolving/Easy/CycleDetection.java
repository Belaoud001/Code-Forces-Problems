package ProblemSolving.HackerRank.ProblemSolving.Easy;

public class CycleDetection {

    static class Node {
        int data;
        Node next;
    }

    // Implementing hare and tortoise algorithm to detect cycle in a linked list
    boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow)
                return true;
        }

        return false;
    }

    // Complete main

}
