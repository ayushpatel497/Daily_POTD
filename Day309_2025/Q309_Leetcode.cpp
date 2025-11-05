class Helper{
    int x;
    long long result;
    set<pair<int, int>> large, small;
    unordered_map<int, int> occurences;

    void internalInsert(const pair<int, int> &p){
        if(large.size() < x || p > *large.begin()){
            result += static_cast<long long> (p.first) * p.second;
            large.insert(p);
            if(large.size() > x){
                result -= static_cast<long long> (large.begin() -> first) * large.begin() -> second;
                auto transfer = *large.begin();
                large.erase(transfer);
                small.insert(transfer);
            }
        }
        else{
            small.insert(p);
        }
    }

    void internalRemove(const pair<int, int> &p){
        if(p >= *large.begin()){
            result -= static_cast<long long> (p.first) * p.second;
            large.erase(p);
            if(!small.empty()){
                result += static_cast<long long> (small.rbegin() -> first) * small.rbegin() -> second;
                auto transfer = *small.rbegin();
                small.erase(transfer);
                large.insert(transfer);
            }
        }
        else{
            small.erase(p);
        }
    }
public:
    Helper(int x) {
        this -> x = x;
        this -> result = 0;
    }

    void insert(int num){
        if(occurences[num]){
            internalRemove({occurences[num], num});
        }
        ++occurences[num];
        internalInsert({occurences[num], num});
    }

    void remove(int num){
        internalRemove({occurences[num], num});
        --occurences[num];
        if(occurences[num]){
            internalInsert({occurences[num], num});
        }
    }

    long long get() {
        return result;
    }
};

class Solution {
public:
    vector<long long> findXSum(vector<int>& nums, int k, int x) {
        // Q. Find X-Sum of All K-Long Subarrays II
        Helper helper(x);
        vector<long long> answer;

        for(int index = 0; index < nums.size(); ++index){
            helper.insert(nums[index]);
            if(index >= k){
                helper.remove(nums[index - k]);
            }
            if(index >= k - 1){
                answer.push_back(helper.get());
            }
        }
        return answer;
    }
};