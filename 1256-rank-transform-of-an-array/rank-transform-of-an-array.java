class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] s = arr.clone();
        Arrays.sort(s);

        HashMap<Integer, Integer> map = new HashMap<>();
        int r = 1;
        for(int n: s){
            if(!map.containsKey(n)){
                map.put(n, r);
                r++;
            }
        }
        for(int i = 0; i < arr.length; i++){
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}