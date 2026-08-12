class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       Set<String> set = new HashSet<>(wordList);
       if(!set.contains(endWord)){
        return 0;
       }

       Queue<String> q = new LinkedList<>();
       q.offer(beginWord);

       int level = 1;
       while(!q.isEmpty()){
        int size = q.size();
        for(int i = 0; i < size ; i++){
            String w = q.poll();
            if(w.equals(endWord)){
                return level;
            }
            char[] ch = w.toCharArray();
            for(int j = 0; j < ch.length; j++){
                char org = ch[j];
                for(char c = 'a'; c <= 'z'; c++){
                    ch[j] = c;
                    String newWord = new String(ch);

                    if(set.contains(newWord)){
                        q.offer(newWord);
                        set.remove(newWord);
                    }
                }
                ch[j] = org;
            }
        }
        level++;
       }
       return 0;
    }
}