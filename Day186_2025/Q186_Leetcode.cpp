class Solution {
public:
    int findLucky(vector<int>& arr) {
        // Q. Find Lucky Integer in an Array
        unordered_map<int, int> freq;
        for (int num : arr) {
            freq[num]++;
        }
        int lucky = -1;
        for (auto& [key, value] : freq) {
            if (key == value) {
                lucky = max(lucky, key);
            }
        }

        return lucky;
    }
};