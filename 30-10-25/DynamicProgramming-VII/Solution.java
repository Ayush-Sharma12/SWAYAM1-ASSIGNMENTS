import java.util.Arrays;

public class Solution {
    public int countSubstrings(String s) {
           
            int i = 0;
            
            int ans = 0;  
            int[][] cache = new int[s.length()][s.length()];
            for(int[] c : cache) {
                   Arrays.fill(c, -1);
            }
           
            while(i < s.length()){
                   
                 int j = 0;
                 int count = 1; 
                 while(j < i) {
                       if(isPalindrome(s, cache, j, i) == 1) {
                              cache[j][i] = 1;
                              count++;
                       }else{
                          cache[j][i] = 0;
                       }

                       j++;
                 }
                 
                 ans += count;

                 i++;    
            }

            return ans;
    }

    private int isPalindrome(String s, int[][] cache, int idx1, int idx2) {
           
            
            while(idx1 < idx2) {
                  
                   if(cache[idx1][idx2] != -1) {
                        return cache[idx1][idx2];
                   } 
                 
                   if(s.charAt(idx1++) != s.charAt(idx2--)) {
                          return 0;
                   }
            }

            return 1;
    }
} 
