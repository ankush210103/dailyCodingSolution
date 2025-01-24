class Solution {
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printP(int[] arr,int index,List<List<Integer>> res){
        if(index == arr.length){
            List<Integer> response = new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                response.add(arr[i]);
            }

            res.add(new ArrayList<>(response));
            return;
        }
        for(int j=index;j<arr.length;j++){
            swap(arr,index,j);
            printP(arr,index+1,res);
            swap(arr,index,j);
        }
    }


    public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            printP(nums,0,res);

            return res;

    }
}