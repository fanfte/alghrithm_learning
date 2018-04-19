package com.fanfte.algorithm.recursive;

public class NumOfIslands {

    static int res = 0;

    static int[][] dir = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    public static boolean inArea(int x, int y, int m, int n) {
        if(x >= 0 && x < m && y >= 0 && y < n) {
            return true;
        }
        return false;
    }

    public static int numIslands(char[][] grid) {

        if(grid == null || grid.length <= 0 ) {
            return res;
        }

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        for(int i = 0;i < m;i++) {
            for(int j = 0; j < n;j++) {
                visited[i][j] = false;
            }
        }

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0;j < grid[0].length;j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    res ++;
                    floodFill(grid, i, j, visited);
                }
            }
        }
        return res;
    }

    private static void floodFill(char[][] grid, int startX, int startY, boolean[][] visited) {
        visited[startX][startY] = true;
        for(int i = 0;i < 4;i++) {
            int newX = startX + dir[i][0];
            int newY = startY + dir[i][1];
            if(inArea(newX, newY, grid.length, grid[0].length) && !visited[newX][newY] && grid[newX][newY] == '1') {
                floodFill(grid, newX, newY, visited);
            }
        }
        return;
    }

    public static void main(String[] args) {
        char[][] nums = new char[][] {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'},
                                        {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        int res = numIslands(nums);
        System.out.println(res);
    }
}
