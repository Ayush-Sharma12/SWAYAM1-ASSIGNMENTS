import java.util.*;
public class CombinationSum2 {
    
}
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
                  Arrays.sort(candidates);
                  List<List<Integer>> ans = new ArrayList<>();

                  f(ans,candidates,target, 0, new ArrayList<>());

                  return ans;
    }

    private void f(List<List<Integer>> ans, int[] candidates, int x, int idx, List<Integer> al) {
           
              if(x == 0) {
                   ans.add(new ArrayList<>(al));
                   return;
              }

              if(x < 0 || idx == candidates.length) {
                   return;
              }


              for(int i = idx; i<candidates.length; i++) {
                    al.add(candidates[i]);
                    f(ans, candidates, x - candidates[i], i, al);
                    al.remove(al.size()-1);
              }

    }
}
