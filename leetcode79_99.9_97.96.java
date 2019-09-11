package leet_test;

        import java.util.*;

public class Main {


//    public static class ListNode{
//        int val;
//        ListNode next;
//        ListNode(int x) {val=x;}
//    }

    public static void main(String[] args) {
        char[][] board = {
                {'b'},
                {'a'},
                {'b'}
        };
        String word = "bbabab";

        boolean res = exist(board, word);
        System.out.println(res);
    }

    public static boolean exist(char[][] board, String word){
        char[] w = word.toCharArray();

        for(int i =0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(check(j, i, w, board, 0)) return true;
            }
        }
        return false;

    }
    public static boolean check(int x, int y, char[] word, char[][] board, int start){
        if(start == word.length) return true;

        if(y<0||x<0||y==board.length || x == board[0].length) return false;

        if(board[y][x]!=word[start]) return false;

        board[y][x] ^= 256;

        boolean res = (check(x-1, y, word, board, start+1))
                || check(x, y-1, word, board, start+1)
                || check(x+1, y, word, board, start+1)
                || check(x, y+1, word, board, start+1);

        board[y][x] ^=256;
        return res;
    }
}
