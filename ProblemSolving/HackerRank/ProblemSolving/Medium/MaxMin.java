package ProblemSolving.HackerRank.ProblemSolving.Medium;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;


public class MaxMin {

    class Result {

        public static int maxMin(int k, List<Integer> arr) {
            Collections.sort(arr);

            int minimum = Integer.MAX_VALUE;

            for(int i = 0; i + k <= arr.size(); i++)
                minimum = Math.min(arr.get(i + k - 1) - arr.get(i), minimum);

            return minimum;
        }

    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            int k = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> arr = IntStream.range(0, n).mapToObj(i -> {
                        try {
                            return bufferedReader.readLine().replaceAll("\\s+$", "");
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    })
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(toList());

            int result = Result.maxMin(k, arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }
    }

}
