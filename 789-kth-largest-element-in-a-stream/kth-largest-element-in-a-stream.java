class KthLargest {
    private PriorityQueue<Integer> minh;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minh = new PriorityQueue<>();

        for(int n : nums){
            add(n);
        }

    
    }
    
    public int add(int val) {
        
        minh.offer(val);
        if(minh.size() > k){
            minh.poll();
        }
       return minh.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */