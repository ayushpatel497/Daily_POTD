class Solution {
    int getXSum(unordered_map<int, int> frequency, int x){
        priority_queue<pair<int, int>> maxHeap;
        for(auto entry : frequency){
            maxHeap.push({entry.second, entry.first});
        }

        int sum = 0;
        while(x-- && !maxHeap.empty()){
            auto entry = maxHeap.top();
            maxHeap.pop();
            sum += entry.first * entry.second;
        }

        return sum;
    }
public:
    vector<int> findXSum(vector<int>& nums, int k, int x) {
        // Q. Find X-Sum of All K-Long Subarrays I
        vector<int> answer;
        unordered_map<int, int> frequency;

        for(int index = 0; index < k; ++index){
            frequency[nums[index]]++;
        }

        answer.push_back(getXSum(frequency, x));

        for(int index = 1; index <= nums.size() - k ; ++index){
            frequency[nums[index - 1]]--;
            if(frequency[nums[index - 1]] == 0){
                frequency.erase(nums[index - 1]);
            }

            frequency[nums[index + k - 1]]++;
            answer.push_back(getXSum(frequency, x));
        }

        return answer;
    }
};