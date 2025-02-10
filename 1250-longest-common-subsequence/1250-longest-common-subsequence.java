class Solution {

    public static int lcs(int i,String s1,int j,String s2,int[][] ans){
        if(i<0 || j<0) return 0;

        if(ans[i][j]!= -1){
            return ans[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)){
            ans[i][j] = 1+ lcs(i-1,s1,j-1,s2,ans);
        }else{
            ans[i][j] = Math.max(lcs(i-1,s1,j,s2,ans),lcs(i,s1,j-1,s2,ans));
        }
        return ans[i][j];

    }


    public int longestCommonSubsequence(String text1, String text2) {
        int[][] ans = new int[text1.length()][text2.length()];
        for(int i=0;i<text1.length();i++){
            for(int j=0;j<text2.length();j++){
                ans[i][j] = -1;
            }
        }
        int res = lcs(text1.length()-1,text1,text2.length()-1,text2,ans);
        return res;
    }
}