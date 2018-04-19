package com.fanfte.algorithm.recursive;

public class    SearchWord {

    static int[][] dir = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    static int m, n;

    static boolean[][] visited;
    public static boolean exist(char[][] board, String word) {
        boolean res = false;
        m = board.length;
        assert m > 0;
        n = board[0].length;
        visited = new boolean[m][n];
        for(int i = 0;i < m;i++) {
            for(int j = 0; j < n;j++) {
                visited[i][j] = false;
            }
        }

        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                res = searchWord(board, 0, word, i, j);
                if(res) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean searchWord(char[][] board, int index, String word, int startX, int startY) {

        //访问到字符串的最后一个元素了
        if(index == word.length() - 1) {
            return board[startX][startY] == word.charAt(index);
        }
        if(board[startX][startY] == word.charAt(index)) {
            //访问回溯
            visited[startX][startY] = true;
            //向四个方向遍历
            for (int i = 0; i < 4; i++) {
                int newX = startX + dir[i][0];
                int newY = startY + dir[i][1];
                if(inArea(newX, newY) && !visited[newX][newY] &&
                        searchWord(board, index + 1, word, newX, newY)) {
                    return true;
                }
            }
            visited[startX][startY] = false;
        }
        return false;
    }
    private static boolean inArea(int newX, int newY) {
        if(newX >=0 && newX < m && newY >= 0 && newY < n) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][]  board = new char[][] {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        boolean isExist = exist(board, "ABCCED");
        System.out.println(isExist);
    }
}
