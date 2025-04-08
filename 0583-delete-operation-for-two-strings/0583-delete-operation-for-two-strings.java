class Solution {

    public static int solve(String s,String t){
        int n =s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];

        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }

        for(int j=0;j<=m;j++){
            dp[0][j] = 0;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[n][m];

    }


    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        return n+m - (2* solve(word1,word2));
    }
}