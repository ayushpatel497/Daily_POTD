class Solution {
  public:
    int assignHole(vector<int>& mices, vector<int>& holes) {
        // Q. Assign Mice Holes
        // code here
        sort(mices.begin(), mices.end());
        sort(holes.begin(), holes.end());
        int res = 0;
        for(int i = 0; i < mices.size(); i++){
            res = max(res, abs(holes[i] - mices[i]));
        }
        return res;
    }
};