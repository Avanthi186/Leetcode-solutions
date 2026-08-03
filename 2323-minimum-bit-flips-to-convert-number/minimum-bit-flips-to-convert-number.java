class Solution {
    public int minBitFlips(int start, int goal) {
        int xor = start ^ goal;
        int c = 0;

        while(xor != 0){
            c += xor & 1;
            xor= xor >> 1;

        }
        return c;
    }
}