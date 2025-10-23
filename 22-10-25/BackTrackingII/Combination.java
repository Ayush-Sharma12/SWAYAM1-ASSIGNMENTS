import java.util.*;
class Solution {
    public List<List<Integer>> combine(int n, int k) {
          
 
         
       List<List<Integer>> ll = new ArrayList<>();  
         findingcombination( ll, 1, n,  k, new ArrayList<>());
         return ll;  
    }

    public void findingcombination(List<List<Integer>> ll,int start, int n,  int k, List<Integer> al)
    {
            if(al.size() == k)
            {
                
                ll.add(new ArrayList<>(al));
                     return;
            }
           
           for(int i=start; i<=n; i++)
           {
                  
                 al.add(i);
                 findingcombination( ll, i+1, n,  k, al);
                 al.remove(al.size()-1);

           }
           
    }
}