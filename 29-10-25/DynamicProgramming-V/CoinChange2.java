import java.util.*;
public class CoinChange2 {
    
}

class Solution {

    public int change(int amount, int[] coins) {
         

        int[][] dp = new int[coins.length][amount+1]; 

        for(int[] rows : dp) {
             Arrays.fill(rows, -1);
        }
        return count(amount, coins, 0, dp);       
           
     
}

    int  count(int x, int[] coins, int idx, int[][] dp) {

           
            

             if(idx == coins.length) return 0;
             if(x == 0) { 

                   return 1;
             }
             
 
            if(dp[idx][x] != -1) return dp[idx][x];
             
             
             int notTake = count(x, coins, idx + 1, dp);

             int take = 0;
             if(coins[idx] <= x) take = count(x - coins[idx], coins, idx, dp);  


             return dp[idx][x] = take + notTake;

            

    }
}
