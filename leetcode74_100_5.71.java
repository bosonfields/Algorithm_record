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
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,50}
        };
        int target = 51;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target){
        if(matrix.length==0 || matrix[0].length==0) return false;

        if(target<matrix[0][0]) return false;

        if(target>matrix[matrix.length-1][0]) return bColSrch(matrix[matrix.length-1], 0, matrix[0].length-1, target);

        return bRowSrch(matrix, 0, matrix.length-1, target);

    }
    public static boolean bRowSrch(int[][] matrix, int start, int end, int target){
        if(end-start<=1) return matrix[end][0] == target || bColSrch(matrix[start], 0, matrix[0].length-1, target);
        int mid  = (end+start)/2;
        if(matrix[mid][0] == target) return true;
        else if(matrix[mid][0] < target) return bRowSrch(matrix, mid, end, target);
        else return bRowSrch(matrix, start, mid, target);
    }
    public  static boolean bColSrch(int[] row, int start, int end, int target){
        if(start>end) return false;
        int mid = (end+start)/2;
        if(row[mid] == target) return true;
        else if(row[mid]<target) return bColSrch(row, mid+1, end, target);
        else return bColSrch(row, start, mid-1, target);
    }
}
