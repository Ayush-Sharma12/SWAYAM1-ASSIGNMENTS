public class RegularExpressionMatching {
    
}

class Solution {
    public boolean isMatch(String s, String p) {
          
          
          int n1 = s.length();
          int n2 = p.length();
          int[][] dp = new int[n1][n2];
          for(int[] d : dp){
              Arrays.fill(d, -1);
          }
          
          return solve(s, p, dp, n1, n2, 0, 0); 
    }

    private boolean solve(String s, String p, int[][] dp, int n1, int n2, int i, int j){

            if(j == n2) {
                   return i == n1;
            }   
              
            if(i < n1 && dp[i][j] != -1){
                   return dp[i][j] == 0 ? false : true;
            }  
           
            boolean firstMatch = false;

            if(i < n1 && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')){
                   firstMatch = true;
            }
          
            boolean res = false; 
            if(j+1 < n2 && p.charAt(j+1) == '*'){
                   boolean notTake = solve(s, p, dp,  n1, n2, i, j+2);
                   boolean take = firstMatch && solve(s, p, dp, n1, n2, i+1, j);

                    res =  notTake || take;
            }else {
                   res =  firstMatch && solve(s, p, dp,  n1, n2, i+1, j+1);
             }

            if(i < n1) 
             dp[i][j] = res ? 1 : 0;

             return res;
   }
}
