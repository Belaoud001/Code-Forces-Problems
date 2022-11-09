import java.util.*;

public class Labyrinth {

    static int[] dX = {0, 1, -1, 0};
    static int[] dY = {-1, 0, 0, 1};
    static char[] directions = {'U', 'R', 'L', 'D'};
    static String shortestPath = "";
    static StringBuilder path = new StringBuilder();
    static int minimumCost = Integer.MAX_VALUE;
    static Map<Pair, Pair> pairMap = new HashMap<>();
    static char[][] grid;
    static int n;
    static int m;

    private static class Pair {
        int x;
        int y;
        char direction;

        public Pair(int x, int y, char direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

    public static boolean isValid(int x, int y) {
        return x < n && y < m && x >= 0 && y >= 0 && (grid[x][y] == '.'  || grid[x][y] == 'B');
    }

    public static void bfs(Pair cell) {
        Queue<Pair> queue = new LinkedList<>();
        boolean found = false;
        queue.add(cell);

        while (!queue.isEmpty()) {
            cell = queue.poll();

            if (grid[cell.x][cell.y] == 'B') {
                found = true;
                break;
            }

            grid[cell.x][cell.y] = '#';

            for (int i = 0; i < 4; i++)
                if (isValid(cell.x + dX[i], cell.y + dY[i])) {
                    Pair neighbor = new Pair(cell.x + dX[i], cell.y + dY[i], directions[i]);
                    queue.add(neighbor);
                    pairMap.put(neighbor, cell);
                }
        }

        if (found)
            while(pairMap.containsKey(cell)) {
                shortestPath += cell.direction;
                cell = pairMap.get(cell);
            }

    }

    /*public static void dfs(Pair cell) {
        if (grid[cell.x][cell.y] == 'B')  {
            if (path.length() < minimumCost) {
                minimumCost = path.length();
                shortestPath = path.toString();
            }
        }

        grid[cell.x][cell.y] = '#';

        for (int i = 0; i < 4; i++) {
            if (isValid(cell.x + dX[i], cell.y + dY[i])) {
                path.append(directions[i]);
                dfs(new Pair(cell.x + dX[i], cell.y + dY[i]));
                path.deleteCharAt(path.length() - 1);
            }
        }

        grid[cell.x][cell.y] = '.';
    }*/

    public static void solve() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 'A')
                    bfs(new Pair(i, j, '-'));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        grid = new char[n][m];

        for (int i = 0; i < n; i++)
            grid[i] = scanner.next().toCharArray();

        solve();
        System.out.println(shortestPath.length() == 0 ? "NO" : "YES");
        System.out.println(shortestPath.length());
        System.out.println(shortestPath);
    }

}
