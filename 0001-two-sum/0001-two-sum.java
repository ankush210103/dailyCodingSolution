class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        int firstIndex=-1;
        int secondIndex = -1;

        for(int i=0;i<nums.length;i++){
            int remaining = target- nums[i];
            if(map.containsKey(remaining) && map.get(remaining)!= i){
                firstIndex = i;
                secondIndex = map.get(remaining);
            }
        }
        int[] arr = {firstIndex,secondIndex};
        return arr;
    }
}