class Solution {
    public int longestPalindromeSubseq(String s) {
        
        String s2 = "";

        for(int i=s.length()-1; i>=0; i--) {

              s2 += s.charAt(i);
        }

        int  m = s.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
      
        for(int[] row : dp) {
               Arrays.fill(row, -1);
        }
         


        // return tabulation(s, s2, dp, m, n);
        return memo(s, s2, dp, m, n);
       

        
              
    }

    int tabulation(String s1,  String s2, int[][] dp, int m, int n) {

           if(m == 0 || n==0) return 0;

           for(int i=1; i<=m; i++) {

             for(int j = 1; j<=n; j++) {

                     if(s1.charAt(i-1) == s2.charAt(j-1)) {

                           dp[i][j] = 1 + dp[i-1][j-1];
                     } 
                     else{
                          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                     }
             }

       } 


    return dp[m][n];

    }

    int memo(String s1, String s2, int[][] dp, int m, int n) {

                   if(m == 0 || n == 0) return 0;


                    if(dp[m][n] != -1) return dp[m][n];
                  
                   if(s1.charAt(m-1) == s2.charAt(n-1)) {
                       
                        return dp[m][n] = 1 + memo(s1, s2, dp, m-1, n-1);
                   } 

                   else{

                       
                        return dp[m][n] = Math.max(memo(s1, s2, dp, m-1, n), memo(s1, s2, dp, m, n-1));
                   }
             
    }
}