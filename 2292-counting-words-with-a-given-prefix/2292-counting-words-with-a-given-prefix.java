class Solution {
    public int prefixCount(String[] words, String pref) {
        int len =  pref.length();
        int count =0;
        for(int i=0;i<words.length;i++){
            int len2 = words[i].length();
            int k=0;
            while(k<len && k<len2){
                if(words[i].charAt(k) == pref.charAt(k)){
                    k++;
                }else{
                    break;
                }
            }
            if(k == len){
                count++;
            }
        }
        return count;
    }
}