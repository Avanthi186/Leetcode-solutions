class Solution {
    private int k;
    private int[] product;
    private int[][] prefix;
    private int runningProduct;
    private int answer;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.k = k;
        int n = nums.length;

        product = new int[4 * n];
        prefix = new int[4 * n][k];

        build(1, 0, n - 1, nums);

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            update(1, 0, n - 1, index, value);

            runningProduct = 1 % k;
            answer = 0;

            query(1, 0, n - 1, start, x);
            result[i] = answer;
        }

        return result;
    }

    private void build(int node, int left, int right, int[] nums) {
        if (left == right) {
            product[node] = nums[left] % k;
            prefix[node][product[node]] = 1;
            return;
        }

        int mid = left + (right - left) / 2;

        build(node * 2, left, mid, nums);
        build(node * 2 + 1, mid + 1, right, nums);

        merge(node);
    }

    private void merge(int node) {
        int a = node * 2;
        int b = node * 2 + 1;

        product[node] = (int) ((long) product[a] * product[b] % k);
        System.arraycopy(prefix[a], 0, prefix[node], 0, k);

  
        for (int r = 0; r < k; r++) {
            int remainder = (int) ((long) product[a] * r % k);
            prefix[node][remainder] += prefix[b][r];
        }
    }

    private void update(int node, int left, int right,
                        int index, int value) {
        if (left == right) {
            prefix[node][product[node]] = 0;

            product[node] = value % k;
            prefix[node][product[node]] = 1;
            return;
        }

        int mid = left + (right - left) / 2;

        if (index <= mid) {
            update(node * 2, left, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, right, index, value);
        }

        merge(node);
    }

    private void query(int node, int left, int right,
                       int start, int x) {
        if (right < start) return;

        if (left >= start) {
            for (int r = 0; r < k; r++) {
                int remainder =
                    (int) ((long) runningProduct * r % k);

                if (remainder == x) {
                    answer += prefix[node][r];
                }
            }
            runningProduct =
                (int) ((long) runningProduct * product[node] % k);
            return;
        }
        int mid = left + (right - left) / 2;
        query(node * 2, left, mid, start, x);
        query(node * 2 + 1, mid + 1, right, start, x);
    }
}