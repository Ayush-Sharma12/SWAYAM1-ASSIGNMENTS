


class SetMatrixZero {
    public void setZeroes(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] skip = new boolean[m][n];

        for(int i=0; i<matrix.length; i++) {

               for(int j=0; j<matrix[i].length; j++) {
                      
                       if(matrix[i][j] == 0  && !skip[i][j]) { // mark skip[i][j] for avoiding repeatedly operation
                            placeZero(matrix, i, j, skip);
                            skip[i][j] = true;
                            
                       }
                       
               }
               
        }


    }

    void placeZero(int[][] matrix, int i, int j, boolean[][] skip) {

         

           for(int k = 0; k < matrix.length ; k++) {
                   
                  if(matrix[k][j] != 0 ) { // row vise
                      matrix[k][j] = 0;
                      skip[k][j] = true;
                  }

                 
           }

           for(int l=0; l<matrix[0].length; l++) {
               
                    if(matrix[i][l] != 0) { // col wise
                       matrix[i][l] = 0;
                       skip[i][l] = true;
                  }
           }
    }
}