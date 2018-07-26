package com.fanfte.algorithm.jz;

/**
 * Created by dell on 2018/7/23
 **/
public class PrintMatrixInCircle020 {

    public static void main(String[] args) {
        int[][] m = new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        new PrintMatrixInCircle020().printMatrixIncircle(m);
    }

    public void printMatrixIncircle(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;

        while(tR <= dR && tC <= dC) {
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    private void printEdge(int[][] matrix, int tR, int tC, int dR, int dC) {
        if(tR == dR) {
            for(int i = tC;i <= dC; i ++) {
                System.out.print(matrix[tR][i] + " ");
            }
        } else if(tC == dC) {
            for(int i = tR;i <= dR; i ++) {
                System.out.print(matrix[i][tC] + " ");
            }
        } else {
            int curC = tC;
            int curR = tR;

            while(curC < dC) {
                System.out.print(matrix[tR][curC] + " ");
                curC ++;
            }
            while(curR < dR) {
                System.out.print(matrix[curR][dC] + " ");
                curR ++;
            }
            while(curC > tC ) {
                System.out.print(matrix[dR][curC] + " ") ;
                curC --;
            }
            while(curR > tR) {
                System.out.print(matrix[curR][tC] + " ");
                curR --;
            }
        }
    }
}
