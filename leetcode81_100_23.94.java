package leet_test;

        import java.util.*;

public class Main {


//    public static class ListNode{
//        int val;
//        ListNode next;
//        ListNode(int x) {val=x;}
//    }

    public static void main(String[] args) {

        int[] nums = {1,1,3,1};
        boolean res = search(nums, 3);
        System.out.println(res);

    }

    public static boolean search(int[] nums, int target){
        if(nums.length==0) return false;

        return bSearch(nums, target, 0, nums.length-1);

    }
    public static boolean bSearch(int[] nums, int target, int head, int end){
        if(head > end) return false;

        if(nums[head] == nums[end]){
            if(nums[head] == target) return true;
            else return bSearch(nums, target, head+1, end-1);
        }
        int mid = (head + end) /2;

        if(nums[mid] == target) return true;


        if(nums[mid]<=nums[end]){
            if(target>nums[end] || target<nums[mid]) return bSearch(nums, target, head, mid-1);
            else return bSearch(nums, target, mid+1, end);
        }
        else{
            if(target<nums[head] || target> nums[mid]) return bSearch(nums, target, mid+1, end);
            else return bSearch(nums, target, head, mid-1);
        }
    }
}
