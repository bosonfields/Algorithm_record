package leet_test;

        import java.util.*;

public class Main {


    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {val=x;}
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };

        int res = maximalRectangle(matrix);

        System.out.println(res);
    }

    public static int maximalRectangle(char[][] matrix){
        if(matrix.length==0||matrix[0].length==0) return 0;
        int m = matrix.length, n = matrix[0].length;

        int[] memH = new int[n];
        int maxAr = 0;

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                memH[j] = matrix[i][j] == '0'? 0:memH[j]+1;
            }
            maxAr = Math.max(maxAr, search(memH));
        }
        return maxAr;
    }

    public static int search(int[] memH){
        int p = 0, idx = 0;
        int[] tmp = new int[memH.length+1];
        tmp[0] = -1;
        int currH = 0;
        int maxAr = 0;

        while(idx<=memH.length){
            if(p>0 && (idx==memH.length || memH[tmp[p]]>memH[idx])){
                currH = memH[tmp[p--]];
                maxAr = Math.max(maxAr, (idx - tmp[p]-1) * currH);
            }else{
                tmp[++p] = idx++;
            }
        }
        return maxAr;
    }
}
