class Solution {
  public:
    int minOperations(vector<int>& nums, int k) {
        // Q. Minimum Operations to Exceed Threshold Value II
        priority_queue<int, vector<int>, greater<int>> minHeap;
        for (int num : nums) {
            minHeap.push(num);
        }
        int count = 0;
        while (minHeap.top() < k) {
            int first = minHeap.top();
            minHeap.pop();
            int second = minHeap.top();
            minHeap.pop();
            count++;
            int doubledMin = min(first, second) * 2;
            int val;
            if (doubledMin >= k) {
                val = doubledMin;
            } else {
                val = doubledMin + max(first, second);
            }
            minHeap.push(val);
        }
        return count;
    }
};