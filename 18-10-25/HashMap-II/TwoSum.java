import java.util.*;
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
          
          Map<Integer, Integer> map = new HashMap<>();
          
          int n = nums.length;
          int first = -1;
          int sec = -1;
          for(int i = 0; i<n; i++) {
                 if(map.containsKey(target - nums[i])) {
                        int idx = map.get(target - nums[i]);
                        first = idx;
                        sec = i;
                        break;
                 } 
              
                 map.put(nums[i], i);
          }
        
        
         return new int[]{first, sec};
    }
}