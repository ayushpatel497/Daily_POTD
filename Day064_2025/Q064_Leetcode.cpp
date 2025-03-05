class Solution {
    public:
        long long coloredCells(int n) {
            // Q. Count Total Number of Colored Cells
            return 1 + (long long)n * (n - 1) * 2;
        }
    };