class Solution {
    public int rob(int[] nums) {
          
        
          if(nums.length < 2) return nums[0];
          if(nums.length == 2) return Math.max(nums[0], nums[1]);
 

        // Skip First house. 
           int[] first = new int[nums.length];
           first[1] = nums[1];
           first[2] = Math.max(first[1], nums[2]);

           for(int i = 3; i<first.length; i++) {
               
               first[i] = Math.max(first[i-2] + nums[i], first[i-1]);
                
           }
           
           // Skip last house
           int n = nums.length-1;  
           int[] last = new int[n];
           last[0] = nums[0];
           last[1] = Math.max(nums[0], nums[1]);

           for(int i = 2; i<n; i++) {

               last[i] = Math.max(last[i-2] + nums[i], last[i-1]);
           }


           int res = Math.max(first[first.length-1], last[last.length-1]);

            return res;
    }
}