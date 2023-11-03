package ProblemSolving.HackerRank.ProblemSolving.Medium;

import java.io.*;
import java.util.stream.*;

public class Primality {

    static class Result {

        public static String primality(int number) {
            boolean isPrime = number != 1;

            for(int j = 2; j <= Math.sqrt(number); j++)
                if(number % j == 0)
                    isPrime = false;

            return isPrime ? "Prime" : "Not prime";
        }

    }

    public static class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int p = Integer.parseInt(bufferedReader.readLine().trim());

            IntStream.range(0, p).forEach(pItr -> {
                try {
                    int n = Integer.parseInt(bufferedReader.readLine().trim());

                    String result = Result.primality(n);

                    bufferedWriter.write(result);
                    bufferedWriter.newLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            bufferedReader.close();
            bufferedWriter.close();
        }
    }

}
