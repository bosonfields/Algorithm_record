class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rcheck = new int[9];
        int[] ccheck = new int[9];
        int[] bcheck = new int[9];
        int tmp = 0;
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j]!='.'){
                    tmp = 1 << (board[i][j] - '0');
                    if((tmp & rcheck[i])>0 ||
                       (tmp & ccheck[j])>0 ||
                       (tmp & bcheck[(i/3)*3 +j/3])>0){
                        return false;
                    }
                    rcheck[i] |= tmp;
                    ccheck[j] |=tmp;
                    bcheck[(i/3)*3+j/3] |=tmp;
                }
            }
        }
        return true;
    }
}