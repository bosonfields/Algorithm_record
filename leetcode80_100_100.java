package leet_test;

        import java.util.*;

public class Main {


//    public static class ListNode{
//        int val;
//        ListNode next;
//        ListNode(int x) {val=x;}
//    }

    public static void main(String[] args) {

        int[] nums = {1,1,1,2,2,3};
        int res = removeDuplicates(nums);

        System.out.println(res);

    }

    public static int removeDuplicates(int[] nums){
        int i = 0;
        for(int n:nums){
            if(i<2 || n>nums[i-2]) nums[i++] = n;
        }
        return i;
    }
}
