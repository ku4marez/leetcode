package interview.preparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {

        // 1. Count Islands
        char[][] grid = {
                {'1', '1', '0', '0'},
                {'1', '0', '0', '1'},
                {'0', '0', '1', '1'}
        };
        System.out.println("Number of islands: " + countIslands(grid));

        // 2. Flood Fill
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int[][] filled = floodFill(image, 1, 1, 2);
        System.out.println("Flood filled image: " + Arrays.deepToString(filled));

        // 3. All Paths in Grid (Backtracking)
        List<List<String>> paths = findAllPaths(2, 2);
        System.out.println("All paths in 2x2 grid: " + paths);

        // 4. Maze Path Existence
        int[][] maze = {
                {0, 0, 1},
                {1, 0, 1},
                {1, 0, 0}
        };
        System.out.println("Path exists in maze? " + pathExists(maze, 0, 0, 2, 2));

        // 5. Connected Components in Graph
        int n = 5;
        int[][] edges = {
                {0, 1}, {1, 2}, {3, 4}
        };
        System.out.println("Connected components: " + countComponents(n, edges));
    }

    // 1. Count Islands
    public static int countIslands(char[][] grid) {
        int count = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    countIslands(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;

    }

    private static void countIslands(char[][] grid, int x, int y, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        if (x < 0 || y < 0 || x >= m || y >= n) return;
        if (grid[x][y] != '1' || visited[x][y]) return;

        visited[x][y] = true;

        countIslands(grid, x + 1, y, visited);
        countIslands(grid, x - 1, y, visited);
        countIslands(grid, x, y + 1, visited);
        countIslands(grid, x, y - 1, visited);
    }

    // 2. Flood Fill
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length, n = image[0].length;
        boolean[][] visited = new boolean[m][n];
        int originalColor = image[sr][sc];

        // avoid infinite loop if color is already newColor
        if (originalColor == newColor) return image;

        floodFill(image, sr, sc, visited, originalColor, newColor);
        return image;
    }

    private static void floodFill(int[][] grid, int x, int y, boolean[][] visited, int originalColor, int newColor) {
        int m = grid.length, n = grid[0].length;
        if (x < 0 || y < 0 || x >= m || y >= n) return;
        if (grid[x][y] != originalColor || visited[x][y]) return;

        visited[x][y] = true;
        grid[x][y] = newColor;

        floodFill(grid, x + 1, y, visited, originalColor, newColor);
        floodFill(grid, x - 1, y, visited, originalColor, newColor);
        floodFill(grid, x, y + 1, visited, originalColor, newColor);
        floodFill(grid, x, y - 1, visited, originalColor, newColor);
    }

    // 3. All Paths in Grid (0,0) → (m-1,n-1), only ↓ and →
    public static List<List<String>> findAllPaths(int m, int n) {
        List<List<String>> paths = new ArrayList<>();
        if (m == 0 || n == 0) return paths;
        backtrackPaths(0, 0, m, n, new ArrayList<>(), paths);
        return paths;
    }

    private static void backtrackPaths(int i, int j, int m, int n, List<String> path, List<List<String>> res) {
        if (i == m - 1 && j == n - 1) {
            res.add(new ArrayList<>(path));
            return;
        }

        // Move right
        if (j + 1 < n) {
            path.add("→");
            backtrackPaths(i, j + 1, m, n, path, res);
            path.remove(path.size() - 1);
        }

        // Move down
        if (i + 1 < m) {
            path.add("↓");
            backtrackPaths(i + 1, j, m, n, path, res);
            path.remove(path.size() - 1);
        }
    }


    // 4. Maze Path Existence (0 = free, 1 = wall)
    public static boolean pathExists(int[][] maze, int sr, int sc, int tr, int tc) {
        return false;
    }

    // 5. Count Connected Components in Graph
    public static int countComponents(int n, int[][] edges) {
        return 0;
    }
}

