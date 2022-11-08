package EasyProblems;

import java.util.Scanner;
import java.util.Stack;

public class CountingRooms {

    static int[] dX = {0, 1, -1, 0};
    static int[] dY = {1, 0, 0, -1};
    static char[][] grid;
    static int n;
    static int m;

    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean isValid(int x, int y) {
        return x < n && y < m && x >= 0 && y >= 0 && grid[x][y] == '.';
    }

    public static void dfs(Pair cell) {
        Stack<Pair> stack = new Stack<>();
        stack.push(cell);

        while (!stack.isEmpty()) {
            cell = stack.pop();
            grid[cell.x][cell.y] = '#';

            for (int i = 0; i < 4; i++)
                if (isValid(cell.x + dX[i], cell.y + dY[i]))
                    stack.push(new Pair(cell.x + dX[i], cell.y + dY[i]));
        }
    }

    public static int solve() {
        int count = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '.') {
                    dfs(new Pair(i, j));
                    count++;
                }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        grid = new char[n][m];

        for (int i = 0; i < n; i++)
            grid[i] = scanner.next().toCharArray();

        System.out.println(solve());
    }

}
