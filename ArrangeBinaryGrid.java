/*
problem: we are given a grid and allowed to do adjacent swaps only. we should return min swaps required such that all the cells
         above main diagonal becomes zeroes.

Approch: Maintain an array which stores how many trailing zeroes it has and do swapping this array elements itself

Time Complexity: O(n^2)+O(n)*(2*O(n))
Space Complexity:O(n)

*/

class Solution {

    public int minSwaps(int[][] grid) {

        int n = grid.length;
        int[] trailingZeroes = new int[n];

        // Step 1: Count trailing zeros for each row
        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    count++;
                } else {
                    break; // stop when we see first 1 from right
                }
            }

            trailingZeroes[i] = count;
        }

        int swaps = 0;

        // Step 2: Fix each row one by one
        for (int i = 0; i < n; i++) {

            int required = n - i - 1;
            int row = i;

            // Find a row below that satisfies required trailing zeros
            while (row < n && trailingZeroes[row] < required) {
                row++;
            }

            // If no such row found, impossible
            if (row == n) {
                return -1;
            }

            // Bring that row up using adjacent swaps
            while (row > i) {
                int temp = trailingZeroes[row];
                trailingZeroes[row] = trailingZeroes[row - 1];
                trailingZeroes[row - 1] = temp;

                row--;
                swaps++;
            }
        }

        return swaps;
    }
}
