public class CokoEatingBanana {
       public static void main(String[] args) {
           // 
       }
}

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
            /*
              Time complexity: O(nlog(maxpile))
              Space Complexity: O(1);  
               
             */

            int max = 0;
            for(int pile : piles) {
                  max = Math.max(max, pile);
            }

            int low = 1;
            int high = max;
           
            int ans = -1;
            while(low <= high) {
                   int k = low + (high - low) / 2;
                  
                   if(canEatAllBanana(k, piles, h)) {
                       ans = k;
                       high = k - 1;
                   }else{
                       low = k + 1;
                   }


            }


            return ans;

    }

    private boolean canEatAllBanana(int k, int[] piles, int h) {
           
           long totalHour = 0;
           for(int pile : piles) {
             
              totalHour += (int)Math.ceil((double)pile/k);       
           }


           return totalHour <= h;
    } 
}
