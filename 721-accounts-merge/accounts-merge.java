class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, String> emailname = new HashMap<>();

        for(List<String> a : accounts){
            String name = a.get(0);
            String femail = a.get(1);
            emailname.put(femail, name);
            graph.putIfAbsent(femail, new ArrayList<>());
            for(int i = 2; i < a.size(); i++){
                String email = a.get(i);
                emailname.put(email, name);
                graph.putIfAbsent(email, new ArrayList<>());

                graph.get(femail).add(email);
                graph.get(email).add(femail);
            }
        }

        List<List<String>> res = new ArrayList<>();

        Set<String> v = new HashSet<>();

        for(String e: graph.keySet()){
            if(!v.contains(e)){
                List<String> emails= new ArrayList<>();
                dfs(e,graph, v, emails);
                Collections.sort(emails);
                List<String> acc = new ArrayList<>();
                acc.add(emailname.get(e));
                acc.addAll(emails);
                res.add(acc);
            }
        }
        return res;
    }
    private void dfs(String e, Map<String, List<String>> graph, Set<String> v, List<String> emails){
        v.add(e);
        emails.add(e);
        for(String nei: graph.get(e)){
            if(!v.contains(nei)){
                dfs(nei, graph, v, emails);
            }
        }
    }
}