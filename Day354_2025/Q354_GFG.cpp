class Solution {
  public:
    int searchInsertK(vector<int> &arr, int k) {
        // Q. Search insert position of K in a sorted array
        // code here
        int start = 0, end = arr.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < k) { 
                start = mid + 1;
            } else { 
                end = mid - 1; 
            }
        }
        return start;
    }
};