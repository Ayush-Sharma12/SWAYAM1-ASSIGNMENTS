
import java.util.Arrays;

public class AggerisiveCows {
    
}


class GfG {
    
    // function to check if we can place k cows
    // with at least dist distance apart
    static boolean check(int[] stalls, int k, int dist) {
        
        // Place first cow at 0th index
        int cnt = 1;  
        int prev = stalls[0]; 
        for (int i = 1; i < stalls.length; i++) {
            
            // If the current stall is at least dist away
            // from the previous one place the cow here
            if (stalls[i] - prev >= dist) {
                prev = stalls[i]; 
                cnt++; 
            }
        }

        // Return true if we are able to place all 'k' cows
        return (cnt >= k);
    }

    static int aggressiveCows(int[] stalls, int k) {
        
        // sorting the array to ensure stalls in sequence
        Arrays.sort(stalls);
        int res = 0; 
        
        // Minimum and maximum possible minimum distance
        // between two stalls
        int minDist = 1;
        int maxDist = stalls[stalls.length - 1] - stalls[0];  

        // Iterating through all possible distances 
        for (int i = minDist; i <= maxDist; i++) {
            
            // If we can place k cows with the 
            // current distance i, update the res
            if (check(stalls, k, i))
                res = i;  
        }

        return res;
    }

    public static void main(String[] args) {
        int[] stalls = {1, 2, 4, 8, 9}; 
        int k = 3;
        int ans = aggressiveCows(stalls, k);
        System.out.println(ans);
    }
}
