import java.util.*;
public class HighestFreqCharacter {
    public char getMaxOccuringChar(String s) {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) {
               map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
         
        int maxSmallestChar = 0; 
        int currFreq = 0;
        for(Character ch : map.keySet()) {
              if(currFreq <= map.get(ch)) {
                    maxSmallestChar = Math.max(maxSmallestChar, ch - 'a');
                    currFreq = map.get(ch);
              }
        }
        
        return (char)(maxSmallestChar + 'a');
    }
}