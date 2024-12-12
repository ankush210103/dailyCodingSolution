class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                st.push(arr[i]);
            }else{

                while(!st.isEmpty() && st.peek()>0 && st.peek()< Math.abs(arr[i])){
                    st.pop();
                }

                if(!st.isEmpty() && st.peek() == Math.abs(arr[i])){
                    st.pop();
                }
                else if(st.isEmpty() || st.peek()<0){
                    st.push(arr[i]);
                }
            }
        }

        int[] brr = new int[st.size()];

        int j = brr.length -1;
        while(!st.isEmpty()){
            brr[j--] =st.pop();
        }

        return brr;
    }
}