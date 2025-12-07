class Solution {
public:
    int countOdds(int low, int high) {
        // Q. Count Odd Numbers in an Interval Range
        return ((high + 1) / 2) - (low / 2);
    }
};