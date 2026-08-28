class Solution {
    static final long MOD = 1000000007;
    public int countGoodNumbers(long n) {
        long evenpos = (n + 1)/2;
        long oddpos = n/2;

        long evenways = power(5, evenpos);
        long oddways = power(4, oddpos);

        return (int) ((evenways * oddways) % MOD);

        
    }

    private long power(long base, long exp){
        long res = 1;
        while(exp > 0){
            if(exp % 2 == 1){
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp = exp/2;
        }
        return res;
    }
}