class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;
        HashSet<Character> charS = new HashSet<>();
        for(int i=0;i<s.length();i++){
            while(charS.contains(s.charAt(i))){
                charS.remove(s.charAt(left));
                left++;
            }
            charS.add(s.charAt(i));
            maxLength = Math.max(maxLength,i-left+1);
        }
        return maxLength;
    }
}