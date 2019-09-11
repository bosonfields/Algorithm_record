package leet_test;

        import org.w3c.dom.ls.LSException;

        import java.util.*;

public class Main {


//    public static class ListNode{
//        int val;
//        ListNode next;
//        ListNode(int x) {val=x;}
//    }

    public static void main(String[] args) {
        int input = 2;
        List<Integer> ans = grayCode(input);

        System.out.println(ans.toString());
    }

    public static List<Integer> grayCode(int n){
        List<Integer> res = new ArrayList<>();
        if(n==0){
            res.add(0);
            return res;
        }

        res = grayCode(n-1);

        for(int i = res.size()-1; i>=0; i--){
            res.add(res.get(i) + (1<<n-1));
        }
        return res;
    }
}
