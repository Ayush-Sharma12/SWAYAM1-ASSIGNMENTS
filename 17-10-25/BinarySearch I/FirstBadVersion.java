public class FirstBadVersion {
     
      public boolean isBadVersion(int version) {
           return false;
      }
}

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

class Solution extends FirstBadVersion {
    public int firstBadVersion(int n) {
            /*
                time Complexity = O(logn)
                space Complexity: O(1);
            */
            int l = 1;
            int h = n;
              
            int badVersion = -1;  
            while( l <= h) {
                   int currVersion = l + (h - l) / 2;
                 
                   if(isBadVersion(currVersion)) {
                        badVersion = currVersion;
                        h = currVersion - 1;
                   } else{
                      l = currVersion + 1;
                   }
 
            }

            return badVersion;
    }
}