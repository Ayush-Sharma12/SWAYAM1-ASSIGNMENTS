import java.util.*;
class Solution {
    int count = 0;
    public int uniquePaths(int m, int n) {
        

             int[][] dp = new int[m][n]; 
             for(int[] row : dp){
                   Arrays.fill(row, -1);
             }
            return countPath(0, 0, m, n, dp);  
            
             
              
      }

     int  countPath(int D, int R, int m, int n, int[][] dp){
          
              if(D == m || R == n) return 0;

              if(D == m-1 && R == n-1) {
                
                   return 1;

              } 

              if(dp[D][R] != -1) return dp[D][R];
              

            return dp[D][R] = countPath(D, R+1, m, n, dp) + countPath(D+1, R, m, n, dp); 
           
      }
}