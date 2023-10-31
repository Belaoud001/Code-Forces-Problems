package ProblemSolving.HackerRank.ProblemSolving.Medium;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

public class CastleOnTheGrid {

    class Result {
        static int[] dX = {0, 1, -1, 0};
        static int[] dY = {1, 0, 0, -1};
        static char[][] grid2;
        static boolean[][] visited;
        static int[][] distances;

        public static boolean isValid(int x, int y, int n) {
            return x >= 0 && x < n && y >= 0 && y < n && grid2[x][y] != 'X';
        }

        static class Pair {
            int x;
            int y;

            public Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public static int minimumMoves(List<String> grid, int startX, int startY, int goalX, int goalY) {
            int n = grid.size();

            grid2     = new char[n][n];
            visited   = new boolean[n][n];
            distances = new int[n][n];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    grid2[i][j] = grid .get(i).charAt(j);
                }
            }

            Queue<Pair> queue = new LinkedList<>();

            queue.add(new Pair(startX, startY));
            visited[startX][startY] = true;

            while(!queue.isEmpty()) {
                Pair pair = queue.poll();

                for(int i = 0; i < 4; i++) {
                    int neighborX = pair.x + dX[i];
                    int neighborY = pair.y + dY[i];

                    while(isValid(neighborX, neighborY, n)) {
                        if(!visited[neighborX][neighborY]) {
                            queue.add(new Pair(neighborX, neighborY));
                            visited[neighborX][neighborY] = true;

                            distances[neighborX][neighborY] = distances[pair.x][pair.y ] + 1;

                            if(neighborX == goalX && neighborY == goalY)
                                return distances[neighborX][neighborY];
                        }

                        neighborX += dX[i];
                        neighborY += dY[i];
                    }
                }
            }

            return -1;

        }

    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                        try {
                            return bufferedReader.readLine();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    })
                    .collect(toList());

            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int startX = Integer.parseInt(firstMultipleInput[0]);

            int startY = Integer.parseInt(firstMultipleInput[1]);

            int goalX = Integer.parseInt(firstMultipleInput[2]);

            int goalY = Integer.parseInt(firstMultipleInput[3]);

            int result = Result.minimumMoves(grid, startX, startY, goalX, goalY);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }
    }
}
