class IntersectionOfTwoArray {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        return findIntersection(nums1, nums2,  new java.util.HashMap<>());
    }

    public  int[] findIntersection(int[] nums1, int[] nums2, java.util.HashMap<Integer, Integer> hmap)
    {
          
           java.util.ArrayList<Integer> al = new java.util.ArrayList<>();
           for(int i=0; i<nums1.length; i++)
           {
             hmap.put(nums1[i] , 0);
           }

           for(int i=0; i<nums2.length; i++)
           {

                   if(hmap.containsKey(nums2[i]))
                   {
                        
                         if(!al.contains(nums2[i]))
                         {
                              al.add(nums2[i]);
                         }
                   }

           }

           
            int[] arr =new int[al.size()];

            for(int i=0; i<al.size(); i++)
            {
                 arr[i] = al.get(i);
            }
         return arr;
          
    }
}