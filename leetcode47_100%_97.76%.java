package leet_test;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] nums = {1,1,3};
        List<List<Integer>> res = permutationsUnique(nums);
        System.out.println(res.toString());

    }
    public static List<List<Integer>> permutationsUnique(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        Arrays.sort(nums);

        uniqueDfs(new ArrayList<>(), visited, nums, ans);

        return ans;
    }
    public static void uniqueDfs(List<Integer> curr, boolean[] visited, int[] nums, List<List<Integer>> ans){
        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(visited[i] || (i>0 && !visited[i-1] && nums[i] == nums[i-1])) continue;
            curr.add(nums[i]);
            visited[i] = true;
            uniqueDfs(curr, visited, nums, ans);
            visited[i] = false;
            curr.remove(curr.size()-1);
        }
    }
}


