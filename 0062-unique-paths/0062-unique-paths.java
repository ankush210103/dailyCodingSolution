class Solution {
    public static int solve(int i,int j,int m,int n,int[][] dp){
        if(i>=m || j>=n) return 0;
        if(i == m-1 && j == n-1) return 1;
        if(dp[i][j]!= -1) return dp[i][j];
        dp[i][j] =solve(i+1,j,m,n,dp) + solve(i,j+1,m,n,dp);
        return dp[i][j];
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        int res = solve(0,0,m,n,dp);
        return res;
    }
}