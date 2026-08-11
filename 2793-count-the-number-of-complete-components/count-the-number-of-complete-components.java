class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e: edges){
            int u = e[0];
            int v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean [] v = new boolean[n];
        int c = 0;
        for(int i = 0; i < n; i++){
            if(!v[i]){
            int[] r = dfs(i, graph, v);
            int ver = r[0];
            int de = r[1];

            int ed = de/2;
            if(ed == ver * (ver - 1) / 2){
                c++;
            }
            }
        }
        return c;
    }
    

    public int[] dfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] v){
        v[node] = true;
        int ver = 1;
        int de = graph.get(node).size();

        for(int nei : graph.get(node)){
            if(!v[nei]){
                int[] r = dfs(nei, graph, v);
                ver+=r[0];
                de+=r[1];
            }
        }
        return new int[]{ver, de};
    }
}