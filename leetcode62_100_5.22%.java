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

        int m = 7, n=3;
        int res = uniquePaths(m, n);
        System.out.println(res);

    }

    public static int uniquePaths(int m, int n){
        if(m==0||n==0) return 1;

        int min = n>m ? m:n;
        int max = n>m ? n:m;

        int ans=1;

        for(int i = 1; i<min; i++){
            ans = ans/i*(i+max-1)+(ans%i)*(i+max-1)/i;
        }

        return ans;
    }
}