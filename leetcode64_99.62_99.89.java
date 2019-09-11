package leet_test;

        import org.omg.PortableInterceptor.INACTIVE;
        import java.util.*;



public class Main {


    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {val=x;}
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };

        int res = minPathSum(grid);
        System.out.println(res);
    }

    public static int minPathSum(int[][] grid){

        int rlen = grid.length;
        int clen = grid[0].length;
        if(rlen==0 || clen==0) return 0;

        return min(grid, 0,0, rlen-1, clen-1, new int[rlen][clen]);
    }

    public static int min(int[][] grid, int row, int col, int rlen, int clen, int[][] mem){

        if(row == rlen && col == clen) return grid[row][col];

        if(row>rlen || col>clen) return Integer.MAX_VALUE;

        if(mem[row][col]!=0) return mem[row][col];

        int left = min(grid, row+1, col, rlen, clen, mem);
        int right = min(grid, row, col+1, rlen, clen, mem);

        mem[row][col] = Math.min(left, right) + grid[row][col];

        return mem[row][col];
    }
}