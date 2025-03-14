class Solution {
    public boolean canFinish(int n, int[][] arr) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<arr.length;i++){
            adj.get(arr[i][1]).add(arr[i][0]);
        }
        int[] indegree = new int[n];
        for(int i=0;i<n;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){

                if(indegree[i] == 0){
                    q.add(i);
                }
            
        }
        ArrayList<Integer> temp = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.remove();
            temp.add(node);
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        return temp.size() == n;
    }
}