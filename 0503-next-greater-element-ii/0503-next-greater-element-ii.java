class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int[] nge = new int[arr.length];
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for(int i=2*n-1;i>=0;i--){
            while(!st.isEmpty() && arr[i%n]>=st.peek()){
                st.pop();
            }
            if(i<n){
            if(st.isEmpty()){
                nge[i] = -1;
            }else{
                nge[i] = st.peek();
            }
            }
            st.push(arr[i%n]);
        }

        return nge;
    }
}