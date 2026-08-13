class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        int[] indeg = new int[numCourses];
        for(int[] p:prerequisites){
            int course = p[0];
            int pre = p[1];
            graph[pre].add(course);
            indeg[course]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
        if(indeg[i] == 0){
            q.offer(i);

        }
        }
        int[] res = new int[numCourses];
        int index = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            res[index++] = curr;

            for(int next: graph[curr]){
                indeg[next]--;
                if(indeg[next]==0){
                    q.offer(next);
                }
            }
        }
        if(index != numCourses){
            return new int[0];
        }
        return res;
    }
}