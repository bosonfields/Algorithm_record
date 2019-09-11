package leet_test;

        import java.util.*;

public class Main {


//    public static class ListNode{
//        int val;
//        ListNode next;
//        ListNode(int x) {val=x;}
//    }

    public static void main(String[] args) {
        int n=4, k=2;
        List<List<Integer>> res = combine(n, k);

        for(List<Integer> ls: res){
            System.out.println(ls.toString());
        }
    }

    public static List<List<Integer>> combine(int n, int k){
        List<List<Integer>> res = new ArrayList<>();

        if(k>n || k<0) return res;

        if(k==0){
            res.add(new ArrayList<>());
            return res;
        }

        res = combine(n-1, k-1);

        for(List<Integer> ls : res){
            ls.add(n);
        }

        res.addAll(combine(n-1, k));
        return res;
    }
}
