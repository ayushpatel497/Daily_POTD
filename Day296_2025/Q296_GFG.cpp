class Solution {
    int squaredDis(vector<int>& point) {
        return point[0] * point[0] + point[1] * point[1];
    }
  public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        // Q. K Closest Points to Origin
        // code here
        priority_queue<pair<int, vector<int>>> maxHeap;
        for (int i=0;i<points.size();i++) {
            int dist = squaredDis(points[i]);
            if (maxHeap.size() < k) {
                maxHeap.push({dist, points[i]});
            } else {
                if (dist < maxHeap.top().first) {
                    maxHeap.pop();
                    maxHeap.push({dist, points[i]});
                }
            }
        }

        vector<vector<int>> res;
        while (!maxHeap.empty()) {
            res.push_back(maxHeap.top().second);
            maxHeap.pop();
        }
    
        return res;
    }
};