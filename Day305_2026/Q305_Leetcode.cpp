class Solution {
public:
    int minMoves(vector<int>& nums) {
        // Q. Minimum Moves to Equal Array Elements
        int lo = ranges::min(nums), moves = 0;
        for (int x : nums) moves += x - lo;
        return moves;
    }
};