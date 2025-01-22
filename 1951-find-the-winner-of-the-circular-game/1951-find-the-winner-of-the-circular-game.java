class Solution {
    public static void winner(List<Integer> arr,int k,int index){
        if(arr.size() ==1){
            return;
        }
        index = (index+k-1)%arr.size();
        arr.remove(index);
        winner(arr,k,index);



    }

    public int findTheWinner(int n, int k) {
        List<Integer> ar = new ArrayList<>();

        for(int i=0;i<n;i++){
            ar.add(i+1);
        }

        winner(ar,k,0);
        return ar.get(0);
    }
}