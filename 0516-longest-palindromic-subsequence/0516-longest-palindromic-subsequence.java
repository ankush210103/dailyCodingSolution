class Solution {

    public static int solve(int i,String s1,int j,String s2,int[][] ans){
        if(i<0 || j< 0) return 0;

        if(ans[i][j] != -1){
            return ans[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            ans[i][j] = 1+solve(i-1,s1,j-1,s2,ans);
        }else{
            ans[i][j] = Math.max(solve(i-1,s1,j,s2,ans),solve(i,s1,j-1,s2,ans));
        }
        return ans[i][j];


    }


    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();
        String str = sb.toString();
        int[][] arr = new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                arr[i][j] = -1;
            }
        }
        int res = solve(s.length()-1,s,str.length()-1,str,arr);
        return res;
    }
}