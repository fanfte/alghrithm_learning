package com.fanfte.algorithm.recursive;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    private static List<List<String>> res = new ArrayList<>();

    //当前列是否有元素
    private static boolean[] col ;
    //反对角线是否有元素
    private static boolean[] dia1;
    //正对角线是否有元素
    private static boolean[] dia2;

    public static List<List<String>> solveNQueens(int n) {

        if(n <= 0) {
            return res;
        }
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        for(int i = 0; i < col.length;i++) {
            col[i] = false;
        }
        for(int i = 0;i < dia1.length;i++) {
            dia1[i] = false;
            dia2[i] = false;
        }
        char[][] board = new char[n][n];
        for(int i = 0 ;i< board.length;i++) {
            for(int j = 0;j < board[0].length;j++) {
                board[i][j] = '.';
            }
        }
        putQueen(n, 0, board);

        return res;
    }

    //n皇后问题，从第index行每个位置尝试去放置皇后，board为放置后的结果
    private static void putQueen(int n, int index, char[][] board) {

        if(index == n) {
            res.add(makeBoard(board));
            return ;
        }

        //按列遍历
        for(int i = 0;i < n;i ++) {
            //当前列没有元素，当前两个对角线都没有元素时才去放置
            if( !col[i] && !dia1[index + i] && !dia2[n - 1 + index - i]) {
                //第index行，第i个元素尝试放置为'Q'
                board[index][i] = 'Q';
                //当前第i列已经放置了元素
                col[i] = true;
                //index+i表示正对角线的序号，从 0 开始到2 * n - 1 根  正对角线(index,i)坐标上有元素，下一次循环该对角线不能放置
                dia1[index + i] = true;
                //反对角线上元素  index-i为有规律递减 加上 n - 1 可以表示它的对角线的序号
                dia2[n - 1 + index - i] = true;
                putQueen(n, index + 1, board);

                col[i] = false;
                dia1[index + i] = false;
                dia2[n - 1 + index - i] = false;
                board[index][i] = '.';
            }
        }
        return ;
    }

    private static List<String> makeBoard(char[][] board) {
        List<String> l = new ArrayList<>();
        for(int i = 0 ;i < board.length;i++) {
            l.add(new String(board[i]));
        }
        return l;
    }

    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(4);
        System.out.println(lists);
    }

}
