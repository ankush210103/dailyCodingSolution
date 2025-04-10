class Solution {

    public static int solve(int i,int j,int[][] obstacle){
        if(i<0 || j<0) return 0;
         if(obstacle[i][j] == 1) return 0;
        if(i==0 && j ==0)return 1;
        
       

        int up = solve(i-1,j,obstacle);
        int left = solve(i,j-1,obstacle);
        return up+left;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[n - 1][m - 1] == 1) return 0;
        int[][] dp = new int[n][m];

        dp[0][0]= 1;
        for(int i=1;i<n;i++){
            if(dp[i-1][0] == 1 && obstacleGrid[i][0] == 0){
                dp[i][0] =1;
            }else{
                dp[i][0] =0;
            }
        }

        for(int j=1;j<m;j++){
            if(dp[0][j-1] == 1 && obstacleGrid[0][j] == 0){
                dp[0][j]= 1;
            }else{
                dp[0][j] =0;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] =0;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[n-1][m-1];

    }
}