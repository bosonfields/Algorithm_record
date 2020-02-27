class Solution {
    public int jump(int[] nums) {        
        int jumps = 0, curEnd = 0, frontier = 0;
        
        for(int i = 0 ; i < nums.length; i++){
            if(i > frontier) return -1;
            if(curEnd >= nums.length - 1) break;

            frontier = Math.max(frontier, i + nums[i]);

            if(i == curEnd){
                jumps++;
                curEnd = frontier;
            }
            
            
        }

        return jumps;
        
    }
}