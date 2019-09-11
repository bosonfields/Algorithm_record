package leet_test;

        import org.omg.PortableInterceptor.INACTIVE;

        import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = {8,-19,5,-4,20};
        int ans = maxSubArray(nums);

        System.out.println(ans);

     }
    public static int maxSubArray(int[] nums){
        if(nums.length==1) return nums[0];

        int max = nums[0], min = nums[0];

        int sum = nums[0];

        for(int i = 1; i<nums.length; i++){
            if(sum+nums[i]<nums[i]) sum = nums[i];
            else sum+=nums[i];
            if(max<sum) max = sum;
        }
        return max;
    }
}