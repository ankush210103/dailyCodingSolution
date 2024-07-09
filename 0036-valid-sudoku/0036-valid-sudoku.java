class Solution {

    public static boolean isValid(char[][] board,int row,int col,char str){
        for(int i=0;i<9;i++){
            if(board[row][i] == str){
                return false;
            }
        }
        for(int i=0;i<9;i++){
            if(board[i][col] == str){
                return false;
            }
        }
        int sRow = row/3*3;
        int sCol  = col/3*3;
        for(int i=sRow;i<sRow+3;i++){
            for(int j=sCol;j<sCol+3;j++){
                if(board[i][j] == str){
                    return false;
                }
            }
        }
        return true;
    }
   
       
   public boolean isValidSudoku(char[][] board) {
    for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.'){
                    continue;
                }else{

                char str = board[i][j];
                board[i][j] = '.';
                if(isValid(board,i,j,str) == false){
                    return false;
                }
                board[i][j] = str;
                }
            }
        }
        return true;
    }
}
