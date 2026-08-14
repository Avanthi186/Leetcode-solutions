class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n + 1];
        for(int i = 0; i <= n ; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] t: times){
            int u = t[0];
            int v = t[1];
            int wt = t[2];

            graph[u].add(new int[]{v, wt});
        }
        int[] d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);

        d[k] = 0;

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.offer(new int[]{0, k});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int di = curr[0];
            int node = curr[1];
            if(di > d[node]){
                continue;
            }
            for(int[] e: graph[node]){
                int next = e[0];
                int wt = e[1];

                if(di + wt < d[next]){
                    d[next] = di + wt;
                    q.offer(new int[]{d[next], next});
                }
            }
        }
        int ans = 0;
        for(int i = 1; i <= n ; i++){
            if(d[i] == Integer.MAX_VALUE){
            return -1;
            }
            ans = Math.max(ans, d[i]);
        }
        return ans;
    }
}