class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap();
        int n = nums.length;
        for(int i=0;i<n;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<n;i++){
            int c = target-nums[i];
            if(map.containsKey(c) && map.get(c)!=i) return new int[]{i,map.get(c)};
        }
        return new int[]{};
    }
}