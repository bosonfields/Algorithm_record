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
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };

        int res = uniquePathsWithObstacles(grid);
        System.out.println(res);
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid){
        if(obstacleGrid.length==0) return 1;

        int rowL = obstacleGrid.length;
        int colL = obstacleGrid[0].length;


        if(obstacleGrid[0][0]==1 || obstacleGrid[rowL-1][colL-1]==1) return 0;

        int[][] steps = new int[rowL][colL];

        steps[0][0] = 1;
        for(int i = 1; i<colL;i++){
            if(obstacleGrid[0][i]==1) steps[0][i]=0;
            else steps[0][i] = steps[0][i-1];
        }

        for(int j = 1; j<rowL; j++){
            if(obstacleGrid[j][0] ==1) steps[j][0]=0;
            else steps[j][0]=steps[j-1][0];
        }

        for(int i=1; i<rowL; i++){
            for(int j=1; j<colL; j++){
                if(obstacleGrid[i][j] ==0) steps[i][j]= steps[i-1][j] + steps[i][j-1];
                else steps[i][j]=0;
            }
        }
        return steps[rowL-1][colL-1];

    }
}