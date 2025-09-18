class Solution {
  public:
    vector<int> nextGreater(vector<int> &arr) {
        // Q. Next Greater Element in Circular Array
        // code here
        int n = arr.size();
        vector<int> result(n, -1);
        stack<int> st;
        for (int i = 0; i < 2 * n; i++) {
            int num = arr[i % n];
            while (!st.empty() && arr[st.top()] < num) {
                result[st.top()] = num;
                st.pop();
            }
            if (i < n) {
                st.push(i);
            }
        }
        return result;
    }
};