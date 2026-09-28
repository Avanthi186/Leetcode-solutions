class Solution {
    public int maxDepth(String s) {
            int depth = 0;
            int maxdep = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '('){
                    depth++;
                    maxdep = Math.max(maxdep, depth);
                }else if(s.charAt(i) == ')'){
                    depth--;
                }
            }
            return maxdep;
    }
}