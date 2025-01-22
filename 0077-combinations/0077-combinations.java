class Solution {

    public static void returnCombine(int n,int k,int index,List<List<Integer>> res,List<Integer> response){
        if(response.size() == k){
            res.add(new ArrayList<>(response));
            return;
        }
        if(index>n){
            return;
        }
        returnCombine(n,k,index+1,res,response);
        int element = index;
        response.add(element);
        returnCombine(n,k,index+1,res,response);
        response.remove(response.size()-1);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> response = new ArrayList<>();
        returnCombine(n,k,1,res,response);
        return res;
    }
}