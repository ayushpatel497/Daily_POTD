class Solution {
  public:
    void segregate0and1(vector<int> &arr) {
        // Q. Segregate 0s and 1s
        // code here
        int start = 0, end = arr.size() - 1;
        while(start < end){
            if(arr[end] == 1){
                end--;
            }
            else if(arr[start] == 0){
                start++;
            }else{
                arr[start++] = 0;
                arr[end--] = 1;
            }
        }
    }
};