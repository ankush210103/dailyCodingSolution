class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int count =0;
       
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j] == 0){
                  matrix[i][j] = 9999999;
                }
            }
        }
        for(int i=0;i<row;i++){
           for(int j=0;j<col;j++){
                if(matrix[i][j] == 9999999){
                    matrix[i][j] = 0;
                    for(int k=0;k<row;k++){
                if(matrix[k][j] == 9999999){
                    continue;
                }else{
                matrix[k][j] = 0;
                }
            }
            for(int k= 0;k<col;k++){
                if(matrix[i][k] == 9999999){
                    continue;
                }else{
                matrix[i][k] = 0;
                }
            }
                }else{
                    continue;
                }
            }
        }
       // System.out.println(count);
        

        
    }
}