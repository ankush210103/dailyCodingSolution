class Solution {

    public static void solve(int[] nums,int index,ArrayList<Integer> res,int[] sum){
        if(index < 0){
            int current =0;
            for(int i=0;i<res.size();i++){
                current^=res.get(i);
            }
            sum[0] +=current;
            return;
        }
        int element = nums[index];
        res.add(element);
        solve(nums,index-1,res,sum);
        res.remove(res.size()-1);

        solve(nums,index-1,res,sum);
    }



    public int subsetXORSum(int[] nums) {
        int[] sum = new int[1];
        solve(nums,nums.length-1,new ArrayList<>(),sum);

        return sum[0];
    }
}