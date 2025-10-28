import java.util.*;
public class MinimumPathSum {
    
}

class Solution {
  
   
    public int minPathSum(int[][] grid) {
        
            
            int m = grid.length;
            int n = grid[0].length;
            int[][] memo = new int[m][n];

            for(int[] rows : memo){
                   Arrays.fill(rows, -1);
            }

          return  getMinSum(grid, memo, m, n, 0, 0);
           
    }

    int getMinSum(int[][] grid, int[][] memo,  int m, int n, int i, int j){

          
              if(i == m || j == n) return Integer.MAX_VALUE;

              if(i == m-1 && j == n-1) {
               
                return grid[i][j];
              }
             
              if(memo[i][j] != -1) return memo[i][j];
              
               
              int right = getMinSum(grid, memo, m, n, i, j+1); 
              int down =  getMinSum(grid,memo,  m, n, i+1, j);

              return memo[i][j] = grid[i][j] + Math.min(right, down);

             

    }
}
