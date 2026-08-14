class Solution {
    public int countPaths(int n, int[][] roads) {

        List<int[]>[] graph = new ArrayList[n];
        for(int i = 0 ; i < n; i++){
            graph[i]  = new ArrayList<>();
        }
        for(int[] r : roads){
            int u = r[0];
            int v = r[1];
            int t = r[2];

            graph[u].add(new int[]{v, t});
            graph[v].add(new int[]{u, t});

        }
        long[] d = new long[n];
        Arrays.fill(d, Long.MAX_VALUE);

        long[] ways = new long[n];
        d[0] = 0;
        ways[0] = 1;
        PriorityQueue<long[]> q = new PriorityQueue<>((a, b) -> Long.compare(a[0],  b[0]));
        q.offer(new long[]{0, 0});
        long MOD = 1_000_000_007;
        while(!q.isEmpty()){
            long[] curr = q.poll();
            long di = curr[0];
            int node = (int)curr[1];

            if(di > d[node]){
                    continue;
                } 
            for(int[] e: graph[node]){
                int next = e[0];
                int wt = e[1];
                long newd = di + wt;
                

                if(newd < d[next]){
                    d[next] = newd;
                    ways[next] = ways[node];
                    q.offer(new long[] {d[next], next});
                }
                else if(newd == d[next]){
                    ways[next] = (ways[next] + ways[node]) % MOD;
                }
            }
           
        }
         return(int) ways[n - 1];
    }
}