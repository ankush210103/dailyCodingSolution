class Solution {
    public static boolean isValid(String[][] board,int row,int col){
        int n=  board.length;
        for(int i=0;i<board.length;i++){
            if(board[row][i] == "Q") return false;
        }
        for(int j=0;j<board.length;j++){
            if(board[j][col] == "Q") return false;
        }
        // north east
        int i = row;
        int j= col;
        while(i>=0 && j<n){
            if(board[i][j] == "Q") return false;
            i--;
            j++;
        }
        i = row;
        j = col;
        // north west;
        while(i>=0 && j>=0){
            if(board[i][j] == "Q") return false;
            i--;
            j--;
        }
        //south east
        i = row;
        j = col;
        while(i<n && j<n){
            if(board[i][j] == "Q") return false;
            i++;
            j++;
        }
        //south west
        i = row;
        j =  col;
        while(i<n && j>=0){
            if(board[i][j] == "Q") return false;
            i++;
            j--;
        }
        return true;

    }
    
    public static void solve (String[][] board,int row,List<List<String>> ans){
        int n =  board.length;
        if(row == board.length){
            List<String> str = new ArrayList<>();
            String res = "";
            for(int i=0;i<board.length;i++){
                for(int j = 0;j<board.length;j++){
                   res+= board[i][j];
                }
                str.add(res);
                res = "";
            }
            ans.add(str);
            return ;
        }

        for(int j=0;j<n;j++){
            if(isValid(board,row,j)){
                board[row][j] = "Q";
                solve(board,row+1,ans);
                board[row][j] = ".";
            }
        }

    } 
    public List<List<String>> solveNQueens(int n) {
        String[][] board = new String[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = ".";
            }
        }
        List<List<String>> ans = new ArrayList<>();

        solve(board,0,ans);
        return ans;
        
    }
}