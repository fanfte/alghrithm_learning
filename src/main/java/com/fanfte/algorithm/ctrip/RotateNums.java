package com.fanfte.algorithm.ctrip;

import java.util.Scanner;

public class RotateNums {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[][] arr = new int[len][len];
        for(int i =0;i< len;i++) {
            for(int j = 0;j < len;j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        rotate(arr);
        for(int i=0;i< len;i++) {
            for(int j =0;j<len;j++) {
                if(j % len == 0 ) {
                    System.out.println();
                }
                System.out.print(arr[i][j] + " ");
            }
        }
    }

    public static void rotate(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while(tR < dR) {
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    private static void rotateEdge(int[][] matrix, int tR, int tC, int dR, int dC) {
        int times = dC - tC;
        int tmp = 0;
        for(int i =0;i != times;i++) {
            tmp = matrix[tR][tC + i];
            matrix[tR][tC + i] = matrix[dR - i][tC];
            matrix[dR - i][tC] = matrix[dR][dC - i];
            matrix[dR][dC - i] = matrix[tR + i][dC];
            matrix[tR + i][dC] = tmp;
        }
    }
}
