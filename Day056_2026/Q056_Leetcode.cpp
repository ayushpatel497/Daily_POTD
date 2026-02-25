class Solution {
    static int findWeight(int num) {
        int weight = 0;
        while (num > 0) {
            weight++;
            num &= (num - 1);
        }
        return weight;
    }
    
    static bool compare(int a, int b) {
        if (findWeight(a) == findWeight(b)) {
            return a < b;
        }
        return findWeight(a) < findWeight(b);
    }
public:
    vector<int> sortByBits(vector<int>& arr) {
        // Q. Sort Integers by The Number of 1 Bits
        sort(arr.begin(), arr.end(), compare);
        return arr;
    }
};