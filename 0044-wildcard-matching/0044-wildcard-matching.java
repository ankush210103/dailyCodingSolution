class Solution {

    public static boolean solve(int i,int j,String s,String p){
        if(i==0 && j==0){
            return true;
        }

        if(i==0 && j != 0){
            for(int jj=0;jj<j;jj++){
                if(p.charAt(jj) != '*'){
                    return false;
                }
            }
            return true;
        }

        if(i!= 0 && j==0){
            return false;
        }

        if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
            return solve(i-1,j-1,s,p);
        }
        if(p.charAt(j-1) == '*'){
            return solve(i-1,j,s,p) || solve(i,j-1,s,p);
        }

        return false;

    }

    public boolean isMatch(String s, String p) {
        int n =s.length();
        int m =p.length();

        // return  solve(n,m,s,p);
        boolean[][] dp = new boolean[n+1][m+1];
        for(int j=1;j<=m;j++){
            boolean flag = true;
            for(int jj=1;jj<j;jj++){
                if(p.charAt(j-1) == '*'){
                    flag = false;
                    break;
                }
            }
            dp[0][j]= flag;
        }

        dp[0][0] = true;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){

                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }else{
                    dp[i][j] = false;
                }

            }
        }

        return dp[n][m];
    }
}