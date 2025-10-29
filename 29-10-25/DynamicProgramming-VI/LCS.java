class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
    
       for(int i=0; i<dp.length; i++)
       {
          for(int j = 0; j<dp[i].length; j++)
          {
                dp[i][j] = -1;
          }
       }    
        //return helper(text1, text2, text1.length(), text2.length(), dp); // via Memoization

        return tabulation(text1, text2, text1.length(), text2.length()); // via Tabulation
    }

    
    public int helper(String s1,  String s2, int m, int n, int[][] dp)
    {
                   
                   if(m == 0 || n == 0){
                    return 0;
                   }

                   if(dp[m][n] != -1) // Memoization to avoid overlapping sub Problem
                   {
                      return dp[m][n];
                   }

                  else  if(s1.charAt(m-1) == s2.charAt(n-1)){
                           
                        return dp[m][n] = 1 + helper(s1, s2, m-1, n-1, dp);   
                       
                   }
                    else{
                      
                       int a = helper(s1, s2, m-1, n, dp); // decrease text1
                       int b = helper(s1, s2, m, n-1, dp);// decrease text2
                       int max = Math.max(a, b);

                       return dp[m][n]  = max;   

                    }
           
    }

    int tabulation(String s1, String s2, int m, int n)
    {
              if(m == 0 || n == 0) return 0;



              int[][] table = new int[m+1][n+1]; // where m is the length of string 1 and n is the length of string  s2.


              for(int i=1; i <= m; i++)
              {
                   for(int j = 1; j <= n; j++)
                   {
                         
                           if(s1.charAt(i-1) == s2.charAt(j-1)){
                                    
                                    table[i][j] = 1 + table[i-1][j-1];
                              
                           } else{
                                 
                                 table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
                           }
                           
                   }
              }



              return table[m][n];
            
    }
}