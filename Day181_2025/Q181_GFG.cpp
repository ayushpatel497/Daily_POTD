class Solution {
    bool canReachHeight(vector<int>& arr, int k, int w, int target) {
        int n = arr.size();
        vector<int> water(n + 1, 0);
        long long ops = 0;
        long long curr = 0;

        for (int i = 0; i < n; ++i) {
            curr += water[i];
            int effectiveHeight = arr[i] + curr;

            if (effectiveHeight < target) {
                int add = target - effectiveHeight;
                ops += add;
                if (ops > k) return false;

                curr += add;
                if (i + w < n)
                    water[i + w] -= add;
            }
        }
        return true;
    }
  public:
    int maxMinHeight(vector<int> &arr, int k, int w) {
        // Q. Max min Height
        // code here
        int mn = *min_element(arr.begin(), arr.end());
            int low = *min_element(arr.begin(), arr.end());
        int high = low + k;
        int answer = low;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canReachHeight(arr, k, w, mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }
};