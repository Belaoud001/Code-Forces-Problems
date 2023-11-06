package ProblemSolving.HackerRank.ProblemSolving.Medium;

import java.io.*;
import java.util.*;


public class GreedyFlorist {

    public class Solution {
        static int getMinimumCost(int k, int[] c) {
            int result = 0;
            int[] prev = new int[k];
            int grPtr = 0;

            Arrays.sort(c);
            for(int i = c.length - 1; i >= 0; i--) {
                result += (prev[grPtr] + 1) * c[i];
                prev[grPtr]++;
                grPtr = grPtr < (k - 1) ? grPtr + 1 : 0;
            }

            return result;
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] c = new int[n];

            String[] cItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int cItem = Integer.parseInt(cItems[i]);
                c[i] = cItem;
            }

            int minimumCost = getMinimumCost(k, c);

            bufferedWriter.write(String.valueOf(minimumCost));
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }
    }

}
