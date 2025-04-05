class Solution {
    public static int solve(int[] coins,int index,int amount){
        if(index == 0){
            return amount%coins[index] == 0 ? 1 : 0; 
        }
        if(amount ==0){
            return 1;
        }
        int notTake = solve(coins,index-1,amount);
        int take = 0;
        if(amount >= coins[index]){
           take = solve(coins,index,amount-coins[index]);
        }
        return take+notTake;
    }

    public int change(int amount, int[] coins) {
        // return solve(coins,coins.length-1,amount);
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int i=0;i<n;i++) dp[i][0] = 0;

        for(int i=0;i<=amount;i++){
            if(i % coins[0] == 0){
                dp[0][i] =1;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){
                int notTake = dp[i-1][j];
                int take = 0;
                if(j >= coins[i]){
                    take = dp[i][j-coins[i]];
                }
                dp[i][j] = take+notTake;
            }
        }

        return dp[n-1][amount];


    }
}