package ProblemSolving.HackerRank.ProblemSolving.Medium;

public class TreeHuffmanEncoding {

	static class Node {
        public int frequency; // the frequency of this tree
        public char data;
        public Node left, right;

    }

    void decode(String s, Node root) {
        Node head = root;

        for(int i = 0; i < s.length(); i++){
            root = s.charAt(i) == '0' ? root.left : root.right;

            if(root.left == null && root.right == null) {
                System.out.print(root.data);
                root = head;
            }
        }
    }

}
