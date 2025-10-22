import java.util.*;
public class NQueen {
    
}

class Solution {
    public List<List<String>> solveNQueens(int n) {
                 
 
            String[][] mat = new String[n][n];
            for(String[] m : mat) {
                   Arrays.fill(m, ".");
            } 
            List<List<String>> ans = new ArrayList<>(); 
            fillQueen(mat, ans,  n, 0);
            return ans;
    }
     

    private void fillQueen(String[][] mat, List<List<String>> ans,  int n, int row) {

             if(row == mat.length) {
                  addAns(ans, mat);
                  return;
             }     


             for(int col = 0; col < n; col++) {
                    if(canPlace(mat, row, col)) {
                           mat[row][col] = "Q";
                           fillQueen(mat, ans, n, row+1);
                           mat[row][col] = ".";
                    }
             }
    }
     

    private boolean canPlace(String[][] mat, int row, int col) {
            

            //vertical 
            for(int i = 0; i<mat.length; i++) {
                  if(i == row) continue;

                  if(mat[i][col] == "Q") {
                     return false;
                  }
            }



            // upper left diagonal
            for(int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
                    if(mat[i][j] == "Q") {
                          return false;
                    }
            }


            // upper right diagonal
            for(int i = row-1, j = col+1; i >= 0 && j<mat.length; i--, j++) {
                    if(mat[i][j] == "Q") {
                          return false;
                    }
            }

            //lower left diagonal
            for(int i = row+1, j = col-1; i<mat.length && j >= 0; i++, j--) {
                    if(mat[i][j] == "Q") {
                          return false;
                    }
            }

            //lower right diagonal

            for(int i = row+1, j = col+1; i<mat.length && j < mat.length; i++,j++) {
                   if(mat[i][j] == "Q") {
                       return false;
                   }
            }



           return true; 

   }


   private void addAns(List<List<String>> ans, String[][] mat) {
              
             List<String> list = new ArrayList<>();

             for(int i = 0; i<mat.length; i++) {
                   StringBuilder sb = new StringBuilder();
                   for(int j = 0; j<mat.length; j++) {
                         sb.append(mat[i][j]);
                   }

                   list.add(sb.toString());

             }  
          
            ans.add(list); 
    } 
   

    
}
