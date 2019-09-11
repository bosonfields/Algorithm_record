package leet_test;

        import java.util.*;

public class Main {


//    public static class ListNode{
//        int val;
//        ListNode next;
//        ListNode(int x) {val=x;}
//    }

    public static void main(String[] args) {
        int[] nums = {2,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums){
        if(nums.length==0  || nums.length==1) return;
        int left = 0, right = nums.length-1, index =0;

        while(index<=right){
            if(nums[index] == 0){
                nums[index] = nums[left];
                nums[left] = 0;
                left++;
            }
            if(nums[index] == 2){
                nums[index] = nums[right];
                nums[right] = 2;
                right--;
            }
            else index+=1;
        }
    }
}
