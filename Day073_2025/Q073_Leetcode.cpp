class Solution {
    bool isValid(vector<int>& candies, long long k, int mid){
        long long maxNumOfChildren = 0;

        for (int pileIndex = 0; pileIndex < candies.size(); pileIndex++) {
            maxNumOfChildren += candies[pileIndex] / mid;
        }

        return maxNumOfChildren >= k;
    }
public:
    int maximumCandies(vector<int>& candies, long long k) {
        // Q. Maximum Candies Allocated to K Children
        int left = 0;
        int right = 0;
        for (int i = 0; i < candies.size(); i++) {
            right = max(right, candies[i]);
        }
        
        while(left < right){
            int mid = left + (right - left + 1) / 2;
            if(isValid(candies, k, mid)){
                left = mid;
            }
            else{
                right = mid - 1;
            }
        }
        return left;
    }
};