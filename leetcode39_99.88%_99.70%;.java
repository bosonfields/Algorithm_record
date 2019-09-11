package leet_test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        List<List<Integer>> res = combinationSum(candidates, target);
        System.out.println(res);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        if(candidates == null ||candidates.length ==0) return new ArrayList<>();

        Arrays.sort(candidates);
        if(target<candidates[0]) return new ArrayList<>();

        List<Integer> pre = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        findComb(candidates, target, pre, 0, res);

        return res;

    }
    public static void findComb(int[] candidates, int target, List<Integer> pre, int start,  List<List<Integer>> res){
       if(target == 0){
           res.add(new ArrayList<>(pre));
       }
       for(int i= start; i<candidates.length && candidates[i]<=target; i++){
           pre.add(candidates[i]);
           findComb(candidates, target - candidates[i], pre, i, res);
           pre.remove(pre.size()-1);
       }
    }
}


