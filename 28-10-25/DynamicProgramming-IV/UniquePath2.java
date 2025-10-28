import java.util.*;
public class UniquePath2 {
    
}

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        

          

          int m = obstacleGrid.length;
          int n = obstacleGrid[0].length;

          if(obstacleGrid[m-1][n-1] == 1) return 0; // robot can't reach if the obstacle is at destination point           
          int[][] dp = new int[m][n]; 

          for(int[] rows : dp) {
             Arrays.fill(rows, -1);
          }

          return totalPath(obstacleGrid, m, n, 0, 0, dp);
    }

    int totalPath(int[][] grid, int m, int n, int down, int right, int[][] dp){

            if(down == m || right == n){
                   return 0;
            }

            if(down == m-1 && right == n-1) {
                  return 1;
            }

            if(dp[down][right] != -1) return dp[down][right];
             
            
            if(grid[down][right] != 1) {
                   
                return  dp[down][right] = totalPath(grid, m, n, down, right+1, dp) + totalPath(grid, m, n, down+1, right, dp);  
            }else return 0; // skip obstacle.

    }
}
