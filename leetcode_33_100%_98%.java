package leet_test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,3};
        int target = 3;
        int res = search(nums, target);
        System.out.println(res);
    }
    public static int search(int[] nums, int target){
        Boolean flag = true;
        return find(nums, 0, nums.length-1, target);
    }
    public static int find(int[] nums, int head, int tail, int target){
        if(tail<head) return -1;

        int mid = (head+tail)/2;
        if(nums[mid]==target) return mid;

        if(nums[mid] <= nums[tail]){
            if(target>nums[mid] && target<= nums[tail]){
                return find(nums, mid+1, tail, target);
            }else return find(nums, head, mid-1,target);
        }
        if(nums[mid]>=nums[head]){
            if(target>=nums[head] && target<nums[mid]){
                return find(nums, head, mid-1, target);
            }else return find(nums, mid+1, tail, target);
        }

        return -1;
    }
}


