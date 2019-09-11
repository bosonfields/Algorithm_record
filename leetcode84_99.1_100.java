package leet_test;

        import java.util.*;

public class Main {


    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {val=x;}
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        int res = largestRectangleArea(heights);

        System.out.println(res);
    }

    public static int largestRectangleArea(int[] heights){
        if(heights==null || heights.length==0) return 0;
        if(heights.length==1) return heights[0];

        int[] mem = new int[heights.length];
        int p = -1;
        int idx = 0;
        int maxAr = 0;
        mem[0] = -1;

        while(idx<=heights.length){
            if(p!=-1 && (idx==heights.length || heights[idx]<=heights[mem[p]])){
                int currH = mem[p];
                int currLBd = (--p==-1)? -1:mem[p];

                maxAr = Math.max(maxAr, (idx - currLBd -1)*heights[currH]);
            }
            else{
                mem[++p] = idx;
                idx++;
            }
        }
        return maxAr;
    }
}
