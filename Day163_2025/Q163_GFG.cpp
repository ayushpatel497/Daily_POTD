class Solution {
  public:
    vector<int> printKClosest(vector<int> arr, int k, int x) {
        // Q. K closest elements
        // Code here
        int n = arr.size();
        int i = 0;
        int low = 0, high = n - 1, pos = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < x) {
                pos = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    
        int left = pos, right = pos + 1;
        if (arr[right] == x) right++;
        vector<int> res;
        while (left >=0 && right < n && res.size() < k) {
            int leftDiff = abs(arr[left] - x);
            int rightDiff = abs(arr[right] - x);
            
            if (leftDiff < rightDiff) {
                res.push_back(arr[left]);
                left--;
            }
            else {
                res.push_back(arr[right]);
                right++;
            }
        }
        while (left >=0 && res.size() < k) {
            res.push_back(arr[left]);
            left--;
        }
        
        while (right < n && res.size() < k) {
            res.push_back(arr[right]);
            right++;
        }
        
        return res;
    }
};