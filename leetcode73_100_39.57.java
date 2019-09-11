package leet_test;

        import org.omg.PortableInterceptor.INACTIVE;
        import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

        import javax.swing.plaf.synth.SynthTextAreaUI;
        import java.util.*;
        import java.util.regex.Pattern;


public class Main {


//    public static class ListNode{
//        int val;
//        ListNode next;
//        ListNode(int x) {val=x;}
//    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };

        setZeros(matrix);

        for(int[] arr : matrix){
            System.out.println(Arrays.toString(arr));
        }

    }

    public static void setZeros(int[][] matrix){
        if(matrix.length==0 || matrix[0].length==0) return;

        int col0 = 1;

        for(int i = 0; i<matrix.length; i++){
            if(matrix[i][0] == 0) col0 =0;
            for(int j = 1; j<matrix[0].length; j++){
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = matrix.length-1; i>=0; i--){
            for(int j = matrix[0].length-1; j>0; j--){
                if(matrix[i][0]==0 || matrix[0][j] == 0) matrix[i][j] =0;
            }
            if(col0==0) matrix[i][0]=0;
        }
    }
}
