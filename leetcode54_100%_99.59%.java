package leet_test;

        import org.omg.PortableInterceptor.INACTIVE;

        import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {2,5,8},
                {4,0,-1},

        };
        List<Integer> ans = spiralOrder(matrix);

        System.out.println(ans.toString());

     }
    public static List<Integer> spiralOrder(int[][] matrix){
        if(matrix.length == 0) return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();

        int start = 0;
        int limit = Math.min((matrix.length+1)/2, (matrix[0].length+1)/2);

        while(start<limit){
            oneSpiral(matrix, ans, start);
            start++;
        }

        return ans;
    }
    public static void oneSpiral(int[][] matrix, List<Integer> ans, int start){
        int m = matrix.length;
        int n = matrix[0].length;
        int col = start;
        int row = start;
        for(; col< n-start; col++){
            ans.add(matrix[row][col]);
        }

        for(row+=1, col = n-start-1; row<m-start; row++){
            ans.add(matrix[row][col]);
        }

        if(row-1==start) return;

        for(col-=1, row = m-start-1; col>= start; col--){
            ans.add(matrix[row][col]);
        }

        if(n-start-1 == start) return;

        for(row-=1, col = start; row>start; row--){
            ans.add(matrix[row][col]);
        }
    }
}