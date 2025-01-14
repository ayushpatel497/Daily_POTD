class Solution {
public:
    vector<int> findThePrefixCommonArray(vector<int>& A, vector<int>& B) {
        // Q. Find the Prefix Common Array of Two Arrays
        int n = A.size();
        vector<int> ans(n), freq(n + 1, 0);
        int common = 0;

        for (int currInd = 0; currInd < n; ++currInd) {
            if (++freq[A[currInd]] == 2) ++common;
            if (++freq[B[currInd]] == 2) ++common;
            ans[currInd] = common;
        }
        return ans;
    }
};