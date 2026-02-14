class Solution {
  public:
    int minTime(vector<int>& arr, int k) {
        // Q. The Painter's Partition Problem-II
        // code here
        int n = arr.size(), l = 0, r = 0;
        for(int i = 0; i < n; i++) {
            l = max(l, arr[i]);
            r += arr[i];
        }
        l--;
        while(r > l + 1) {
            int m = (l + r) / 2, c = 1;
            for(int i = 0, s = 0; i < n && c <= k; i++) {
                s += arr[i];
                if(s > m) c++;
                if(s > m) s = arr[i];
            }
            if(c <= k) r = m;
            else l = m;
        }
        return r;
    }
};