package ProblemSolving.HackerRank.ProblemSolving.Medium;

import java.util.*;

public class TaleOfTwoStacks {

    class MyQueue<T> {
        Stack<Integer> stackOne = new Stack<>();
        Stack<Integer> stackTwo = new Stack<>();

        void flip() {
            while(!stackOne.isEmpty())
                stackTwo.push(stackOne.pop());
        }

        void enqueue(int x) {
            stackOne.push(x);
        }

        void dequeue() {
            if(stackTwo.isEmpty())
                flip();

            stackTwo.pop();
        }

        int peek() {
            if(stackTwo.isEmpty())
                flip();

            return stackTwo.peek();
        }
    }

    public class Solution {
        public void main(String[] args) {
            MyQueue<Integer> queue = new MyQueue<Integer>();

            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();

            for (int i = 0; i < n; i++) {
                int operation = scan.nextInt();
                if (operation == 1) { // enqueue
                    queue.enqueue(scan.nextInt());
                } else if (operation == 2) { // dequeue
                    queue.dequeue();
                } else if (operation == 3) { // print/peek
                    System.out.println(queue.peek());
                }
            }
            scan.close();
        }
    }

}
