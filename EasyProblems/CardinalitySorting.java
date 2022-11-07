package EasyProblems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CardinalitySorting {

    public static Integer countOnes(int n) {
        int count = 0;
        String binaryString = Integer.toBinaryString(n);

        for(int i = 0; i < binaryString.length(); i++)
            if(binaryString.charAt(i) == '1')
                count++;

        return count;
    }

    public static List<Integer> solve(List<Integer> arr) {
        arr.sort(Comparator.comparing(CardinalitySorting::countOnes));
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
