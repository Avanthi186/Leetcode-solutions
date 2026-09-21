class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        HashSet<String> seen = new HashSet<>();
        HashSet<String> rep = new HashSet<>();
        for(int i = 0; i <= n - 10; i++){
            String seq = s.substring(i , i + 10);

            if(seen.contains(seq)){
                rep.add(seq);
            }else{
                seen.add(seq);
            }
        }
        return new ArrayList<>(rep);

    }
}