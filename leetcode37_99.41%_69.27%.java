package leet_test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        char[][] board = {
//                {'.','.','.','.','4','8','2','3','.'},
//                {'.','.','.','.','6','.','.','8','.'},
//                {'8','.','1','2','.','.','9','.','4'},
//                {'4','.','.','5','.','.','.','.','7'},
//                {'.','1','.','.','.','.','.','5','.'},
//                {'6','.','.','.','.','4','.','.','8'},
//                {'2','.','6','.','.','3','7','.','5'},
//                {'.','8','.','.','9','.','.','.','.'},
//                {'.','3','7','6','5','.','.','.','.'}
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        solveSudoku(board);
    }
    public static void solveSudoku(char[][] board){
        if(board == null || board.length==0) return;
        int[] rcheck = new int[9];
        int[] ccheck = new int[9];
        int[] bcheck = new int[9];
        int tmp = 0;
        for(int i =0; i<9; i++){
            for(int j = 0; j<9; j++){
                if(board[i][j] !='.'){
                    tmp = 1<<(board[i][j] - '0');
                    rcheck[i] |= tmp;
                    ccheck[j] |= tmp;
                    bcheck[(i/3)*3+j/3] |=tmp;
                }
            }
        }
        if(solve(board, rcheck, ccheck, bcheck)){
            for(char[] c: board){
                System.out.println(Arrays.toString(c));
            }
        }
    }
    public static boolean solve(char[][] board, int[] rcheck, int[] ccheck, int[] bcheck){
        int poss = 0;
        int count = 1;
        int tmp = 0;
        for(int i = 0; i<9 ; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    poss = (rcheck[i] | ccheck[j] | bcheck[(i / 3) * 3 + j / 3]) >>1;

                    poss = 511 ^ poss;
                    if (poss == 0) return false;

//                    String s = Integer.toBinaryString(poss);
//                    System.out.println(s);

                    while(poss>0){
                        if((poss & 1) == 1){
                            board[i][j] = (char)('0' + count);
                            tmp = 1<<(count);
                            rcheck[i] |= tmp;
                            ccheck[j] |= tmp;
                            bcheck[(i/3)*3+j/3] |= tmp;

                            if(solve(board, rcheck, ccheck, bcheck)) return true;
                            else{
                                board[i][j] = '.';
                                rcheck[i] -= tmp;
                                ccheck[j] -= tmp;
                                bcheck[(i/3)*3+j/3] -= tmp;
                            }
                        }
                        poss>>= 1;
                        count+=1;
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
