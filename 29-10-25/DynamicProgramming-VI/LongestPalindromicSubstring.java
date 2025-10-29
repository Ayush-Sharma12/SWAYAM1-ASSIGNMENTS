

class Solution {
    public String longestPalindrome(String s) {
          
           int n = s.length();
           boolean[][] dp = new boolean[n][n]; 
           int maxLen = 0;
           int start = 0;
           for(int i = 0; i<n; i++) {
                for(int j = i; j<n; j++) {
                     if(isPalindrome(i, j, dp, s)) {
                           if(j - i + 1 > maxLen) {
                                 maxLen = j - i + 1;
                                 start = i;
                           }
                      }  
                }
           }

           return s.substring(start, start + maxLen);
    }


    private boolean isPalindrome(int i, int j, boolean[][] dp, String s) {
            if(i >= j || dp[i][j]) {
                 return true;
            }

            if(s.charAt(i) == s.charAt(j)) {
                  return  dp[i][j] = isPalindrome(i+1, j-1, dp, s);
            }

            return false;
   }
}
