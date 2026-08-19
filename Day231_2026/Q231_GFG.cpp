class Solution {
    int countValidPairs(vector<int>& arr, int x) {
        int n = arr.size();
        long long ans=0;
        for(int i = 0; i < n - 2; i++){
            int j = i + 1;
            int k = n - 1;
            while(j < k){
                long long sum = (long long)arr[i] + arr[j] + arr[k];
                if(sum <= x){
                    ans += (k - j);
                    j++;
                }
                else{
                    k--;
                }
            }
        }

        return ans;
    }
  public:
  int countTriplets(vector<int> &arr, int l, int r) {
        // Q. Triplets with Sum in Range
        // code here
        sort(begin(arr), end(arr));
        int fullRange = countValidPairs(arr, r);
        int leftRange = countValidPairs(arr, l - 1);

        return fullRange - leftRange;
    }
};