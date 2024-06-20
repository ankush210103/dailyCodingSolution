class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        for(int i : nums){
            if(hash.containsKey(i)){
                hash.put(i,hash.get(i)+1);
            }else{
                hash.put(i,1);
            }
        }
        int res= 0;
        for(int key : hash.keySet()){
            if(hash.get(key)>(nums.length)/2){
                res= key;
            }
        }
        return res;
    }
}