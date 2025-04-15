class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();

        Stack<Integer> st = new Stack<>();

        for(int i=0;i<nums2.length;i++){

            while(!st.isEmpty() && st.peek() <nums2[i]){
                map.put(st.peek(),nums2[i]);
                st.pop();
            }
            st.push(nums2[i]);
        }

        int[] res = new int[nums1.length];

        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])){
                res[i] = map.get(nums1[i]);
            }else{
                res[i]= -1;
            }
        }

        return res;
    }
}