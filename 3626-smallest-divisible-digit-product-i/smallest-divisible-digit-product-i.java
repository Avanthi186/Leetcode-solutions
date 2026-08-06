class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            int temp = n;
            int ans = 1;
            while(temp != 0){
                ans*=temp % 10;
                temp/=10;

            }
            if(ans % t == 0)
            return n;
            n++;
        }
    }
}