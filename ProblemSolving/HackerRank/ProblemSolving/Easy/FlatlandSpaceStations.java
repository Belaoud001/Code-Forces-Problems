package ProblemSolving.HackerRank.ProblemSolving.Easy;

import java.io.*;
import java.util.*;


public class FlatlandSpaceStations {

    public class Solution {

        static int flatlandSpaceStations(int n, int[] c) {
            Arrays.sort(c);

            if(c.length == 1)
                return Math.max(n - c[0] - 1, c[0]);
            int result = Math.max((c[1] - c[0]) / 2, c[0]);

            for(int i = 2; i < c.length; i++) {
                int distance = c[i] - c[i - 1];

                if(distance % 2 == 0)
                    distance += 1;

                result = Math.max(result, distance / 2);
            }

            return Math.max(result, n - 1 - c[c.length - 1] > 0 ? n - 1 - c[c.length - 1] : 0);
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int[] c = new int[m];

            String[] cItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < m; i++) {
                int cItem = Integer.parseInt(cItems[i]);
                c[i] = cItem;
            }

            int result = flatlandSpaceStations(n, c);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }
    }


}
