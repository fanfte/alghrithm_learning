package com.fanfte.algorithm.recursive;

import java.util.Arrays;

public class HasPath {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[] visited = new boolean[matrix.length];
        Arrays.fill(visited, false);
        for(int i = 0;i < rows;i ++) {
            for(int j = 0;j < cols;j ++) {
                if(searchPath(matrix, i, j, str, 0, rows, cols, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchPath(char[] matrix, int i, int j, char[] str, int index, int rows, int cols, boolean[] visited) {
        int matrixPos = i * cols + j;
        if(i < 0 || i >= rows || j < 0 || j >= cols || matrix[matrixPos] != str[index] || visited[matrixPos] == true) {
            return false;
        }
        if(index == str.length - 1) return true;
        visited[matrixPos] = true;
        if(searchPath(matrix, i - 1, j, str, index + 1, rows, cols, visited) ||
                searchPath(matrix, i, j + 1, str, index + 1, rows, cols, visited) ||
                searchPath(matrix, i + 1, j , str, index + 1, rows, cols, visited) ||
                searchPath(matrix, i, j -1, str, index + 1, rows, cols, visited)) {
            return true;
        }
        visited[matrixPos] = false;
        return false;
    }


    public static void main(String[] args) {
//        "ABCESFCSADEE",3,4,"ABCCED"
        char[] chars = new char[] {'A', 'B', 'C', 'E', 'S', 'F', 'C', 'S', 'A', 'D', 'E', 'E'};
        char[] str = new char[] {'A', 'B', 'C', 'C', 'E', 'D'};
        System.out.println(new HasPath().hasPath(chars, 3, 4, str));
    }
}
