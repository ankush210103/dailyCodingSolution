import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void returnSubset(int[] nums, int index, List<List<Integer>> res, List<Integer> response) {
        if (index >= nums.length) {
            res.add(new ArrayList<>(response)); // Add a new copy of the current subset
            return; // Ensure the function exits after adding the subset
        }

        // Recursive call without including the current element
        returnSubset(nums, index + 1, res, response);

        // Include the current element and recurse
        int element = nums[index];
        response.add(element);
        returnSubset(nums, index + 1, res, response);

        // Backtrack to remove the last added element
        response.remove(response.size() - 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> response = new ArrayList<>();
        int index = 0;
        returnSubset(nums, index, res, response);

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = solution.subsets(nums);
        System.out.println(subsets);
    }
}
