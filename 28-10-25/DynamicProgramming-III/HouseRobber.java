import java.util.*;;;
class Solution {
    public int rob(int[] nums) {
            
          int n = nums.length;
          int[] dp = new int[n];
          Arrays.fill(dp, -1);
          return maxRob(nums, n, 0, dp);   
    }

    private int maxRob(int[] nums, int n, int idx, int[] dp) {  
            if(idx >= n) {
                  return 0;
            }
          
            if(dp[idx] != -1) {
                 return dp[idx];
            }
            int take = nums[idx] + maxRob(nums, n, idx+2, dp);
            int notTake = maxRob(nums, n, idx+1, dp);


            return dp[idx] = Math.max(take, notTake);

    }
}