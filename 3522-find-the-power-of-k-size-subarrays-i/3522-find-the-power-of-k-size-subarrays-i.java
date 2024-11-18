class Solution {
    /**
     * Find the Power of K-Size Subarrays 
     */
    public int[] resultsArray(int[] nums, int k) {
        // Skip if k is 1
        if(k==1){
            return nums.clone();
        }
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        Deque<Integer> window = new ArrayDeque<>();


        for(int i=0;i<n;i++){
            while(!window.isEmpty() && i- window.peekFirst() >= k){
                window.pollFirst();
            }

            if(window.isEmpty() || nums[i] - nums[i-1] ==1){
                window.offerLast(i);
            }else{
                window.clear();
                window.offerLast(i);
            }

            // add result when the window size is k
            if(i>=k-1){
                result.add(window.size() == k ? nums[i]  : -1);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();


    }
}