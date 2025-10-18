 
// @SuppressWarnings("")

import java.io.Serializable;

class CustomHashMap
{
        static class CustomHashMapCode<K, V>{

                   class Node{
                     K key;
                     V value;

                     public Node(K key, V value)
                     {
                            this.key = key;
                            this.value = value;  
                     }
                     
                   }

                   private int noofNode;
                   private int noofBuckets;
                   private java.util.LinkedList<Node> buckets[];
                 
                   @SuppressWarnings("unchecked")
                   public CustomHashMapCode()
                   {
                        this.noofBuckets = 10;
                         buckets = new java.util.LinkedList[this.noofBuckets];
                         for(int i=0; i<buckets.length; i++)
                         {
                               buckets[i] = new java.util.LinkedList<>();
                         }
                   }

                   public int hashing(K key)
                   {
                          int value = key.hashCode();
                          return Math.abs(value) % 10;
                   }

                   public int searchInll(int bi, K key)
                   {
                           java.util.LinkedList<Node> ll = buckets[bi];

                           for(int i=0; i<ll.size(); i++)
                           {
                                if(ll.get(i).key == key)
                                          return i;
                               }
                                
                               return -1;
                   }
                  @SuppressWarnings("unchecked")
          //         @SuppressWarnings("unused")
                   public void rehashing()
                   {
                            java.util.LinkedList<Node> olderbuckets[] = buckets;
                            buckets = new java.util.LinkedList[noofBuckets * 2];

                            for(int i=0; i<buckets.length; i++)
                            {
                                buckets[i] = new java.util.LinkedList<>();
                            }
                            
                            for(int i=0; i<olderbuckets.length; i++)
                            {

                                java.util.LinkedList<Node> ll = olderbuckets[i];

                                  for(int j=0; j<ll.size(); j++)
                                  {
                                          
                                        Node node = ll.get(j);
                                        put(node.key, node.value);
                                  }
                            }

                   }
                   public void put(K key, V value)
                   {
                             int bi = hashing(key); 
                             int di = searchInll(bi, key);

                                if(di < 0) // key doesn't exists
                               { 
                                 buckets[bi].add( new Node(key, value));
                                 noofNode++;     
                              }
                              else{
                                        Node node = buckets[bi].get(di);
                                        node.value = value;
                              }
                               // if thresold value exceeds. 
                              double lambda = (double)noofNode/noofBuckets; // typecasting int to double
                              if(lambda > 5.0)
                              {
                                         rehashing();
                              }
                   }
           
                  public java.util.ArrayList<K> keySet()
                  { 
                      java.util.ArrayList<K> al = new java.util.ArrayList<>();
                      
                      for(int bi = 0; bi<buckets.length; bi++)
                      {
                               java.util.LinkedList<Node> ll = buckets[bi];
                               for(int di=0; di<ll.size(); di++)
                               {
                                          al.add(ll.get(di).key);
                               }
                      }

                      
                       return al;
                  }

                  public V remove(K key)
                  {
                         int bi = hashing(key);
                         int di = searchInll(bi, key);

                         if(di < 0){
                               return null;
                         }
                         else{ 
                               Node node = buckets[bi].remove(di);
                               noofNode--;
                               return node.value;
                         }
                  }

                  public boolean containsKey(K key)
                  {
                    int bi = hashing(key);
                    int di = searchInll(bi, key);

                    if(di < 0){
                          return false;
                    }
                    else{ 
                      
                          return true;
                    }
                  }
                  
                   public V get(K key)
                   {
                    int bi = hashing(key);
                    int di = searchInll(bi, key);

                    if(di < 0){
                          return null;
                    }
                    else{ 
                          Node node = buckets[bi].get(di);
                          return node.value;
                    }
           }
                 public boolean isEmpty()
                 {
                        return noofNode == 0;
                 } 
           
             public void print()
                  {
                           
                    for(int i=0; i<buckets.length; i++)
                    {
                               java.util.LinkedList<Node> ll = buckets[i];

                               for(int j=0; j<ll.size(); j++)
                               {
                                        System.out.println(ll.get(i).key + "=>" + ll.get(i).value);  
                               }
                    }

                  }   
        }
            
}


public class hashMapImplementation implements Serializable {
           
//     private V value;
           public static void main(String[] args) {
                    
                    CustomHashMap.CustomHashMapCode<String, Integer> chmap = new CustomHashMap.CustomHashMapCode<>();
                    chmap.put("Ayush", 211468);
                    chmap.put("Rahul", 211798);
                    chmap.put("Rajiv", 211074);
                    chmap.put("Priya", 210485);
                    // System.out.println(chmap.isEmpty());
                     
                    java.util.ArrayList<Integer> al  = new java.util.ArrayList<>();
                    for(String key : chmap.keySet())
                    {
                          al.add(chmap.get(key));
                    }
                




           }


}
