class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i :nums){
            set.add(i);
        }

        int longest = 0;
        for(int num : set){
            
            if(!set.contains(num-1)){
                int count =1;
                int element = num;
                while(set.contains(element+1)){
                    count+=1;
                    element +=1;
                }
                longest = Math.max(longest,count);
            }
        }
        return longest;

    }
}