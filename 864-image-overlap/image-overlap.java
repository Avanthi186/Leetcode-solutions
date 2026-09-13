class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int maxOverlap = 0;

        for (int rowShift = -(n - 1); rowShift <= n - 1; rowShift++) {
            for (int colShift = -(n - 1); colShift <= n - 1; colShift++) {

                int overlap = 0;

                for (int row = 0; row < n; row++) {
                    for (int col = 0; col < n; col++) {

                        int newRow = row + rowShift;
                        int newCol = col + colShift;

                        if (newRow >= 0 && newRow < n &&
                            newCol >= 0 && newCol < n) {

                            if (img1[row][col] == 1 &&
                                img2[newRow][newCol] == 1) {
                                overlap++;
                            }
                        }
                    }
                }

                maxOverlap = Math.max(maxOverlap, overlap);
            }
        }

        return maxOverlap;
    }
}