class Solution {
  public:
    int findSmallest(vector<int> &arr) {
        // Q. Not a subset sum
        // code here.
        sort(arr.begin(), arr.end());
        long long smallest = 1;
        for(int i = 0; i < arr.size(); i++){
            if(arr[i] > smallest) {
                break;
            }
            else{
                smallest += arr[i];
            }
        }
        return smallest;
    }
};