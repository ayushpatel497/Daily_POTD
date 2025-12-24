class Solution {
    int pivot(vector<int>& arr){
        int l = 0;
        int h = arr.size() - 1;
        while(l < h){
            int m = l + (h - l) / 2;
            if(arr[m] > arr[h]){
                l = m + 1;
            }
            else h = m;
        }
        return l;
    }
    
public :
    int countLessEqual(vector<int>& arr, int x) {
        // Q. Count elements less than or equal to k in a sorted rotated array
        // code here
        int piv = pivot(arr);

        int c1 = upper_bound(arr.begin(), arr.begin() + piv, x) - arr.begin();
        int c2 = upper_bound(arr.begin() + piv, arr.end(), x) - (arr.begin() + piv);

        return c1 + c2;
    }
};