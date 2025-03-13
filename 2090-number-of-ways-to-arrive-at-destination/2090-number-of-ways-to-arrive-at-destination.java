class Pair{
    int first;
    long second;
    Pair(int _first,long _second){
        this.first = _first;
        this.second = _second;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        final long INF = Long.MAX_VALUE / 2;
        final int MOD = (int) 1e9 +7;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<roads.length;i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
        }

        long[] dist = new long[n];
        Arrays.fill(dist,INF);
        int[] ways = new int[n];
        ways[0] = 1;
        dist[0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(a->a.second));


        pq.offer(new Pair(0,0)); //Starting from node 0 with time 0

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int u = curr.first;
            long time = curr.second;
            // If we've already found a shorter way, skip

            if(time > dist[u]) continue;

            for(Pair it : adj.get(u)){
                int v = it.first;

                long newTime = time + it.second;

                if(newTime < dist[v]){
                    dist[v] = newTime;
                    ways[v] = ways[u];
                    pq.offer(new Pair(v,newTime));
                }else if(newTime == dist[v]){
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }
        return ways[n-1];


    }
}