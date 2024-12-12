class Solution {

    public static int[] nextGreater(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[arr.length];
       
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
               nge[i] = arr.length;
            }else{
                nge[i] = st.peek();
            }
            st.push(i);
        }
        return nge;
    }

     public static int[] previousSmaller(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] pse = new int[arr.length];
        
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pse[i] = -1;
            }else{
                pse[i] = st.peek();
            }
            st.push(i);
        }
        return pse;
    }


    public int sumSubarrayMins(int[] arr) {
        int sum =0;
         final int MOD = 1_000_000_007;
         int[] psee = previousSmaller(arr);
         int[] nge = nextGreater(arr);


         for(int i=0;i<arr.length;i++){
            int left = i - psee[i];
            int right = nge[i] - i;
            sum = (int) ((sum+ (long)right*left*arr[i]%MOD)%MOD);
         }
         return sum;

        
    }
}