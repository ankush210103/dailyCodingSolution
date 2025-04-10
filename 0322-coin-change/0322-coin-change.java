class Solution {

    public static int solve(int index,int[] coins,int amount){
        if(index == 0){
           if(amount % coins[0] == 0){
        return amount / coins[0];
    }

           return Integer.MAX_VALUE;
        }

        
        int take = Integer.MAX_VALUE;
        if(coins[index] <= amount){
           int temp = solve(index, coins, amount - coins[index]);
    if(temp != Integer.MAX_VALUE) {
        take = 1 + temp;
    }
        }
        int notTake = solve(index-1,coins,amount);

        return Math.min(take,notTake);
    }



    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
       
        int[][] dp = new int[n][amount+1];

        for(int i=0;i<n;i++){
            dp[i][0] = 0;
        }

        for(int j=0;j<=amount;j++){
            if(j%coins[0] == 0 ){
                dp[0][j] = j/coins[0];
            }else{
                dp[0][j] = Integer.MAX_VALUE;
            }
        }

        for(int i=1;i<n;i++){
            for(int j= 1;j<=amount;j++){
                int notTake = dp[i-1][j];
                int take = Integer.MAX_VALUE;
                if(coins[i] <= j && dp[i][j - coins[i]] != Integer.MAX_VALUE){
    take = 1 + dp[i][j - coins[i]];
}

                dp[i][j] = Math.min(take,notTake);
            }
        }
         if(dp[n-1][amount] != Integer.MAX_VALUE){
            return dp[n-1][amount];
        }else{
            return -1;
        }
    }
}