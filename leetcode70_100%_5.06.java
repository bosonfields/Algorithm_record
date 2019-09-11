package leet_test;

        import org.omg.PortableInterceptor.INACTIVE;

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
        int n = 4 ;
        System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n){
        int[] mem = new int[n+1];
        return febbi(n, mem);
    }
    public static int febbi(int n, int[] mem){
        if(n==0) return mem[0]=1;
        if(n<0) return 0;
        if(mem[n]>0) return mem[n];
        return mem[n] = febbi(n-1, mem) + febbi(n-2, mem);
    }
}
