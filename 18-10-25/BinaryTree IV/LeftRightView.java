import java.util.*;
public class LeftRightView {
    
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
         List<Integer> list = new ArrayList<>();

         if(root == null)
              return list;

         Queue<TreeNode> q = new LinkedList<>();

         q.add(root);
         
         int level = 0;
         while(!q.isEmpty())
         {
               int size = q.size();

               for(int i=0; i<size; i++)
               {
                     TreeNode x = q.remove();
                     if(x.right != null)
                            q.add(x.right);
                     if(x.left != null)
                            q.add(x.left);
                     
                     
                     if(level == list.size())
                     {
                           list.add(x.val);
                           
                          
                     } 
               } 
                
                level++;
 
             
         }
         
         return list;
    }
}