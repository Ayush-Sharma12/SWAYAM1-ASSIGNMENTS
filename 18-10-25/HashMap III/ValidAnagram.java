import java.util.*;
public class ValidAnagram {
    
}

class Solution {
    public boolean isAnagram(String s, String t) {

          if(t.length() != s.length()) return false; 
         Map<Character, Integer> map = new HashMap<>();

         for(char i : s.toCharArray()) {
                
                 map.put(i, map.getOrDefault(i, 0) + 1);
         } 
           

         for(char i : t.toCharArray()) {
                
                if(!map.containsKey(i)  || map.get(i) < 1) {
                     return false;
                }

                else{
                    map.put(i, map.get(i)-1);
                }
         }  

         return true;
    }
}
