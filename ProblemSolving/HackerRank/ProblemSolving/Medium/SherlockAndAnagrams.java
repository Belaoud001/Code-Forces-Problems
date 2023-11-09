package ProblemSolving.HackerRank.ProblemSolving.Medium;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class SherlockAndAnagrams {

    class Result {

        public static int sherlockAndAnagrams(String s) {
            // Write your code here
            Map<String, Integer> subStringsMap = new HashMap<>();
            String subString;

            for(int i = 0; i < s.length(); i++) {
                subString = "";
                for(int j = i; j < s.length(); j++) {
                    subString += s.charAt(j);

                    char tempArray[] = subString.toCharArray();

                    Arrays.sort(tempArray);

                    subString = new String(tempArray);

                    subStringsMap.merge(subString, 1, Integer::sum);
                }
            }

            int result = 0;

            for (Map.Entry<String, Integer> entry : subStringsMap.entrySet()) {
                result += entry.getValue() * (entry.getValue() - 1) / 2 ;
            }

            return result;
        }

    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int q = Integer.parseInt(bufferedReader.readLine().trim());

            IntStream.range(0, q).forEach(qItr -> {
                try {
                    String s = bufferedReader.readLine();

                    int result = Result.sherlockAndAnagrams(s);

                    bufferedWriter.write(String.valueOf(result));
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
