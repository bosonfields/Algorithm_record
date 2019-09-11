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

        Dfs(res, new ArrayList<>(), 1, k, n);

        return res;
    }

    public static void Dfs(List<List<Integer>> res, List<Integer> curr, int start, int remain, int n){


        if(remain == 0){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = start; i<=n-remain+1; i++){
            curr.add(i);
            Dfs(res, curr, i+1, remain-1, n);
            curr.remove(curr.size()-1);
        }
    }
}
