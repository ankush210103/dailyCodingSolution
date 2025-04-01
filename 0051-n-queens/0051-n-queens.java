class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List <String>> ans=new ArrayList<>();
        char [][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        helper(0,n,board,ans);
        return ans;
        
    }
    //helper function
    public static void helper(int col,int n,char[][]board,List<List<String>>ans){
        //base case
         if (col == n) {  // ✅ Base case: all queens placed
            List<String> result = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                result.add(new String(board[i])); // ✅ Correctly storing board
            }
            ans.add(result);
            return;
        }

        //main logic
        for(int row=0;row<n;row++){
            if(isSafe(row,col,n,board)){
                board[row][col]='Q';
                helper(col+1,n,board,ans);
                board[row][col]='.';
            }

        }
    }

    public static boolean isSafe(int row, int col, int n, char[][] board) {
    // Check karo ki upar wali rows me Queen hai ya nahi
    for (int i = 0; i < board.length; i++) {
        if (board[row][i] == 'Q') {  // Agar upar koi Queen hai to unsafe hai
            return false;
        }
    }
    for(int j=0;j<board.length;j++){
        if(board[j][col] == 'Q') return false;
    }

    //  Check karo ki upper left diagonal me koi Queen hai ya nahi
    int i = row, j = col;
    while (i >= 0 && j >= 0) { // Jab tak board ke andar ho
        if (board[i][j] == 'Q') { // Agar waha Queen hai to unsafe hai
            return false;
        }
        i--; j--; // Move karo upper-left diagonal ki taraf
    }

    // Check karo ki upper right diagonal me koi Queen hai ya nahi
    i = row; j = col;
    while (i >= 0 && j < board.length) { // Jab tak board ke andar ho
        if (board[i][j] == 'Q') { // Agar waha Queen hai to unsafe hai
            return false;
        }
        i--; j++; // Move karo upper-right diagonal ki taraf
    }

    // lower left
    i = row;
    j = col;

    while(i<board.length && j>=0){
        if(board[i][j] == 'Q'){
            return false;
        }
        i++;
        j--;
    }
    // lower right
    i = row;
    j = col;
    while(i<board.length && j<board.length){
        if(board[i][j] == 'Q'){
            return false;
        }
        i++;
        j++;
    }

    // Agar upar kahi bhi Queen nahi mili to safe hai
    return true;
}

}