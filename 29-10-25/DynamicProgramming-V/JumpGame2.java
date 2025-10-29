class Solution {
    public int jump(int[] nums) {

     

           int left = 0, right = 0, jump = 0;
           
  
           while(right < nums.length-1)  {

              
                  int fast = 0;

                  for(int i=left; i<=right; i++) {

                        if(fast < i + nums[i]) fast = i + nums[i];                        
                        
                  }

                  left = right + 1;
                  right = fast;
                  jump++;
              
           }         


            return jump;
    }

    
}