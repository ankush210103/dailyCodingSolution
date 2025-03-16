class Disjoint{
    int[] parent;
    int[] size;
    Disjoint(int n){
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] =1;
        }
    }

    int find(int node){
        if(parent[node] == node){
            return node;
        }
        return find(parent[node]);
    }

    void union(int u,int v){
        int rootU = find(u);
        int rootV = find(v);
        if(rootU != rootV){
            if(size[rootU] < size[rootV]){
                parent[rootU] = rootV;
                size[rootV] +=size[rootU];
            }else{
                parent[rootV] = rootU;
                size[rootU] +=size[rootV];
            }
        }
    }

  
}



class Solution {
    public int makeConnected(int n, int[][] connections) {
        Disjoint ds = new Disjoint(n);

    

        int edgesCount = 0;
        
        for(int[] it : connections){
            int u =it[0];
            int v = it[1];
            if(ds.find(u) != ds.find(v)){
                ds.union(u,v);
              
            }
            else{
                edgesCount++;
            }
        }
       int cnt =0;
        for(int i=0;i<n;i++){
            if(ds.parent[i] == i){
                cnt++;
            }
        }

        if(edgesCount >= cnt-1){
            return cnt-1;
        }else{
            return -1;
        }


    }
}