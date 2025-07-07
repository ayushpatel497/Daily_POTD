class Solution {
  public:
    vector<int> nextLargerElement(vector<int> &arr) {
        // Q. Next Greater Element in Circular Array
        // code here
        int n = arr.size();
        for(int i = 0; i < n; i++){
            arr.push_back(arr[i]);
        }
        stack<int>st;
        for(int i = 0; i < arr.size(); i++){
            while(!st.empty() && arr[st.top()] < arr[i]){
                arr[st.top()] = arr[i];
                st.pop();
            }
            st.push(i);
        }
        while(!st.empty()){
            arr[st.top()] = -1;
            st.pop();
        }
        return vector<int>(arr.begin(), arr.begin() + n);
    }
};