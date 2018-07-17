package com.fanfte.algorithm.jz;

/**
 * Created by dell on 2018/7/16
 **/
public class FindInMatrix003 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};

        boolean b = find(matrix, matrix.length, matrix[0].length, 5);
        System.out.println(b);
    }

    static boolean find(int[][] arr, int rows, int cols, int aim) {
        boolean result = false;
        if(arr != null && rows > 0 && cols > 0) {
            int row = 0;
            int col = cols - 1;
            while(row <= rows - 1 && col >= 0 ) {
                if(arr[row][col] == aim) {
                    result = true;
                    break;
                }else if(arr[row][col] > aim) {
                    col --;
                } else {
                    row ++;
                }
            }
        }
        return result;
    }
}
