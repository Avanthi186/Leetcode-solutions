class Solution {
    int t = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(List<Integer> e: connections){
            int u = e.get(0);
            int v = e.get(1);

            graph[u].add(v);
            graph[v].add(u);
        }
        int[] tin = new int[n];
        int[] low = new int[n];
        Arrays.fill(tin , -1);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, -1,graph, tin , low, ans);
        
         return ans;
    }

    private void dfs(int node, int parent, List<Integer>[] graph, int[] tin , int[] low , List<List<Integer>> ans){
            tin[node] = low[node] = t++;
            for(int nei : graph[node]){
                if(nei == parent){
                    continue;
                }
                if(tin[nei] != -1){
                    low[node] = Math.min(low[node], tin[nei]);
                }else{
                    dfs(nei, node, graph, tin, low, ans);
                    low[node] = Math.min(low[node], low[nei]);
                
                if(low[nei] > tin[node]){
                    ans.add(Arrays.asList(node, nei));
                }
            }
            } 
    }
   
}