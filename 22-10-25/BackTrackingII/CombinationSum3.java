import java.util.*;
public class CombinationSum3 {
    
}

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
          
             Arrays.sort(candidates);
             List<List<Integer>> result = new ArrayList<>();
            helper(candidates, target, result, new ArrayList<>(), 0);

            return result;

    }

    void helper(int[] candidates, int target, List<List<Integer>> res, List<Integer> list, int start) {

              if(target == 0) {
                 
                List<Integer> temp = new ArrayList<>(list); 
                  
                    res.add(temp);
                  
               
                return;
               
            } 
            if(start == candidates.length) return;
  
            if(target < 0) return;


           for(int i=start; i<candidates.length; i++) {

                if (i > start && candidates[i] == candidates[i - 1]) {
                continue; // Skip duplicates
            }
               
                if(candidates[i] > target) break;  

               list.add(candidates[i]);
               helper(candidates, target-candidates[i], res, list, i+1);
               list.remove(list.size()-1);
           }

           
            
    }
}
