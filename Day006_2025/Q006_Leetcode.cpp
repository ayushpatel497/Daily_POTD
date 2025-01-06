class Solution {
public:
    vector<int> minOperations(string boxes) {
        // Q. Minimum Number of Operations to Move All Balls to Each Box
        int n = boxes.size();
        vector<int> ans(n, 0);

        int ballsToLeft = 0, movesToLeft = 0;
        int ballsToRight = 0, movesToRight = 0;

        for (int i = 0; i < n; i++) {
            ans[i] += movesToLeft;
            ballsToLeft += boxes[i] - '0';
            movesToLeft += ballsToLeft;

            int j = n - 1 - i;
            ans[j] += movesToRight;
            ballsToRight += boxes[j] - '0';
            movesToRight += ballsToRight;
        }

        return ans;
    }
};