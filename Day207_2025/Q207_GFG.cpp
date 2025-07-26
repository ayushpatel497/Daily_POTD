class Solution {
  public:
    vector<int> findMajority(vector<int>& arr) {
        // Q. Majority Element - More Than n/3
        // Code here
        int count1 = 0, count2 = 0;
        int ele1 = 0, el2 = 0;
        for (int num : arr) {
            if (count1 == 0 && num != el2) {
                ele1 = num;
                count1 = 1;
            } else if (count2 == 0 && num != ele1) {
                el2 = num;
                count2 = 1;
            } else if (num == ele1) {
                count1++;
            } else if (num == el2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0, count2 = 0;
        for (int num : arr) {
            if (num == ele1)
                count1++;
            if (num == el2)
                count2++;
        }
        int votes = arr.size();
        vector<int> res;
        if (count1 > votes / 3)
            res.push_back(ele1);
        if (count2 > votes / 3 && el2 != ele1)
            res.push_back(el2);
        if (res.size() == 2 && res[0] > res[1]) {
            swap(res[0], res[1]);
        }
        return res;
    }
};