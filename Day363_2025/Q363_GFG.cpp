class Solution {
  public:
    int kthElement(vector<int> &a, vector<int> &b, int k) {
        // Q. K-th element of two Arrays
        // code here
        int i = 0, j = 0;
        int ans = 0;
        while(k > 0 && i < a.size() && j < b.size()){
            if(a[i] < b[j])  ans = a[i++];
            else  ans = b[j++];
            k--;
            if(k == 0)  return ans; 
        }
        
        if(i < a.size())  return a[i + k - 1];
        if(j < b.size())  return b[j + k - 1];
            
        return -1;
    }
};