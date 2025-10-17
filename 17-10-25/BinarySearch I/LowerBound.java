import java.util.*;
public class LowerBound {
    /*
     * lower bound defination smallest index of an element 
     * that is greator than or equal to the given element
     * 
     * 
     */
      public static void main(String[] args) {
             int[] arr = {1, 8, 9, 80, 430, 580, 890};
             
             System.out.println(lowerBound(arr, 43)); 
      }

      private static int lowerBound(int[] arr, int ele) {

        /*
           
         * Time complexity: O(log n)
         * space complexity: O(1)
         */
             int l = 0;
             int h = arr.length - 1;
             int ans = -1;
             while(l <= h) {
                   int mid = l + (h - l) / 2;
                   
                   if(arr[mid] >= ele) {
                       ans = mid;
                       h = mid-1;
                   } else{
                       l = mid+1;
                   }
               
             }

             return ans;
      }
}