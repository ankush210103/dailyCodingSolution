class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        int index = 0;
        createSubset(nums,subset,index,res);
        return res;
        
    }

    public static void createSubset(int[] nums,List<Integer> subset,int index,List<List<Integer>> res){

        if(index>= nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }
        // exclude
        createSubset(nums,subset,index+1,res);

        // include

        int element = nums[index];
        subset.add(element);
        createSubset(nums,subset,index+1,res);
          // Backtrack: remove the last added element to explore other possibilities
        subset.remove(subset.size()-1);

    }
}