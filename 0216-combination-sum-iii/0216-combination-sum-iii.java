class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        solve(1,0, k,n,new ArrayList<>(),res);
        return res;
    }

    public static void solve(int i,int sm,int k,int n,List<Integer> response,List<List<Integer>> res){
        if(k==0){
            if(sm == n){
            res.add(new ArrayList<>(response));
            }
            return;
        }
        if(i>9) return;
        if(sm>n){
            return;
        }
        
        response.add(i);
        solve(i+1,sm+i,k-1,n,response,res);
        response.remove(response.size()-1);

        solve(i+1,sm,k,n,response,res);

    }
}