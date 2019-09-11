package leet_test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        int res = trap(nums);
        System.out.println(res);

    }
    public static int trap(int[] height){
        int h=0, t=height.length-1;

        while(h<t && height[h]<=height[h+1]) h+=1;
        while(t>h && height[t]<=height[t-1]) t-=1;

        int left, right;
        int res = 0;

        while(h<t){
            left = height[h];
            right = height[t];

            if(left<right){
                while(left>height[++h]) res+=left-height[h];
            }else{
                while(right>height[--t]) res+=right - height[t];
            }
        }
        return res;
    }
}


