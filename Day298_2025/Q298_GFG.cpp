class Solution {
  public:
    int minOperations(vector<int>& arr) {
        // Q. Minimum Steps to Halve Sum
        // code here
        priority_queue<double> pq;
        double arr_sum = accumulate(arr.begin(), arr.end(), 0); 
        double target = 0.5* arr_sum;
        
        int cnt =0;
        for(int i=0;i< arr.size();i++){
            pq.push(arr[i]);
        }
        while(arr_sum > target ){
            double largest = pq.top();
            pq.pop();
            pq.push(largest*0.5);
            arr_sum -= 0.5*largest ;
            cnt++;
        }
        return cnt;
    }
};