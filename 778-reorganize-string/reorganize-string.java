
class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> map.get(b) - map.get(a)
        );
        for(char c : map.keySet()) {
            pq.offer(c);
        }
        StringBuilder sb = new StringBuilder();
        char prev = '#';
        while(!pq.isEmpty()) {
            char curr = pq.poll();
            sb.append(curr);
            map.put(curr, map.get(curr) - 1);
            if(prev != '#' && map.get(prev) > 0) {
                pq.offer(prev);
            }
            prev = curr;
        }
        if(sb.length() != s.length()) {
            return "";
        }
        return sb.toString();
    }
}
