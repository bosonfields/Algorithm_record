package leet_test;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] nums = {2,3,1,1,4};
        int output = jump(nums);
        System.out.println(output);

    }
    public static int jump(int[] nums){
        int currFarest = 0, currEnd = 0;
        int jump=0;
        for(int i=0; i<nums.length-1; i++){
            currFarest = Math.max(currFarest, i+nums[i]);
            if(i == currEnd){
                jump++;
                currEnd = currFarest;
            }
        }
        return jump;
    }
}


