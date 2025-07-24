class Solution {
  public:
    int getLastMoment(int n, vector<int>& left, vector<int>& right) {
        // Q. Last Moment Before All Ants Fall Out
        // code here
        int maxt = 0;
        for(int it : left) maxt = max(maxt, it - 0);
        for(int it : right) maxt = max(maxt, n - it);
        return maxt;
    }
};