import java.util.*;
public class PermutationOfString {
    
}

class Solution {
    public List<List<Integer>> permute(int[] nums) {
 
       List<List<Integer>> ll = new ArrayList<>();
     findingpermutation(nums, new ArrayList<>(), ll);
     return ll;   
    }

    public void findingpermutation(int[] nums, List<Integer> perm, List<List<Integer>> ll)
    {

            if(perm.size() == nums.length)
            {
                 ll.add(new ArrayList<>(perm));
                 return;
            }

            for(int i=0; i<nums.length; i++)
            {
            
               if(perm.contains(nums[i]))
                              continue;  
                    perm.add(nums[i]);                  
                    findingpermutation(nums, perm, ll);
                    perm.remove(perm.size()-1);
                    
            }
    }
}
    
