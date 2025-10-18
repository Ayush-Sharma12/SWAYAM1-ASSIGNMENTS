



public class Implementation {
     
     

         public static class Node{
            public Node left;
            public Node right;
             public int data;

             Node(int data){ 
          
                this.data = data;
             }

          }

        public static class BinarySearchTree{
                  
             public Node buildBst(Node root, int val)
             {
                
                  if(root == null)
                  {
                       root = new Node(val);
                       return root;
                  }  
                  
                  else if(val > root.data)
                       root.right = buildBst(root.right, val);

                  else
                      root.left = buildBst(root.left, val);
                      
                      
                      return root;

             }

          } 
           public static void main(String[] args) {
                   
                  int[]  values = {5, 4, 3, 2, 9, 8};

                    Node root = null;
                    BinarySearchTree bst = new BinarySearchTree();
                    for(int i=0; i<values.length; i++)
                    {
                         root = bst.buildBst(root, values[i]);
                                
                    }
                    
                    System.out.println(root.data);
                  
                    
           }
}
