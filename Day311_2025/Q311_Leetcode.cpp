class Solution {
public:
    long long maxPower(vector<int>& stations, int r, int k) {
        // Q. Maximize the Minimum Powered City
        int size = stations.size();
        vector<long long> count(size + 1);
        for(int index = 0; index < size; ++index){
            int left = max(0, index - r);
            int right = min(size, index + r + 1);
            count[left] += stations[index];
            count[right] -= stations[index];
        }

        auto check = [&](long long value) -> bool {
            vector<long long> difference = count;
            long long sum = 0;
            long long remaining = k;

            for(int index = 0; index < size; ++index){
                sum += difference[index];
                if(sum < value){
                    long long add = value - sum;
                    if(remaining < add){
                        return false;
                    }
                    remaining -= add;
                    int end = min(size, index + 2 * r + 1);
                    difference[end] -= add;
                    sum += add;
                }
            }
            return true;
        };

        long long low = ranges::min(stations);
        long long high = accumulate(stations.begin(), stations.end(), 0LL) + k;
        long long result = 0;
        while(low <= high){
            long long mid = low + (high - low) / 2;
            if(check(mid)){
                result = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return result;
    }
};