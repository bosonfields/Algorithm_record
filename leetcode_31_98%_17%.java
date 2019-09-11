package leet_test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = {5,4,7,5,3,2};
        nextPermutation(nums);

        System.out.println(Arrays.toString(nums));
    }
    public static void nextPermutation(int[] nums){
        if(nums.length==0 || nums.length==1) return;

        int len = nums.length;
        int i = len-1;
        while(i>0 && nums[i]<=nums[i-1]){
            i-=1;
        }

        reverse(nums, i, len-1);

        if(i!=0){
            int j = i;
            while(nums[j] <= nums[i-1]){

                j+=1;
            }
            swap(nums, j, i-1);
        }

    }
    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void reverse(int[] nums, int head, int tail){
        while(head<tail){
            swap(nums, head++, tail--);
        }
    }
}


