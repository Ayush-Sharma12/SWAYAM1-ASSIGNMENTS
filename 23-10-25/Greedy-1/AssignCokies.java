import java.util.*;
class AssignCokies{
      public static void main(String[] args) {
           
      }
}
class Solution {
    public int findContentChildren(int[] g, int[] s) {
         
              

             Arrays.sort(s);
             Arrays.sort(g);
              
             int ans = 0; 
              
            int i = 0;
            int j = 0; 
            while(i < s.length && j < g.length) {
                  
                   if(s[i] >= g[j]) {
                       ans++;
                       i++;
                       j++;
                   } else{
                       
                        while( i < s.length && s[i] < g[j]) i++;
                   }
                   
            } 
               
 
            return ans;   
            
             
    }
}