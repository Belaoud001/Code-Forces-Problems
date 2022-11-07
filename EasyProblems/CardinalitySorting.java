package EasyProblems;

import java.util.*;

public class CardinalitySorting {

    public static int countOnes(int n) {
        int count = 0;
        String binaryString = Integer.toBinaryString(n);

        for(int i = 0; i < binaryString.length(); i++)
            if(binaryString.charAt(i) == '1')
                count++;

        return count;
    }

    public static int countOnes2(int n) {
        String binaryString = Integer.toBinaryString(n);

        List<Character> characterList = new AbstractList<>() {
                    @Override
                    public int size() {
                        return binaryString.length();
                    }

                    @Override
                    public Character get(int index) {
                        return binaryString.charAt(index);
                    }
        };

        return Collections.frequency(characterList, '1');
    }

    public static List<Integer> solve(List<Integer> arr) {
        arr.sort(Comparator.comparing(CardinalitySorting::countOnes2));
        return arr;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(){
            {
                add(1);
                add(2);
                add(3);
                add(4);
            }
        };

        System.out.println(CardinalitySorting.solve(arr));
    }
}
