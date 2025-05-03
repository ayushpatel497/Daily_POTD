class Solution {
    public:
        int minDominoRotations(vector<int>& tops, vector<int>& bottoms) {
            // Q. Minimum Domino Rotations For Equal Row
            vector<int> countA(7, 0), countB(7, 0), countSame(7, 0);
            for(int i = 0; i < tops.size(); i++){
                countA[tops[i]]++;
                countB[bottoms[i]]++;
                if(tops[i] == bottoms[i]) countSame[tops[i]]++;
            }
            int n = tops.size(), ans = n;
            for(int i = 1; i <= 6; i++){
                if(countA[i] + countB[i] - countSame[i] == n){
                    ans = min(ans, n - max(countA[i], countB[i]));
                }
            }
            return ans == n ? -1 : ans;
        }
    };