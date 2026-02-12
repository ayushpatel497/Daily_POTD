class Solution {
    bool isOK(vector<int> &arr, int days, int cs, int h){
            int n = arr.size();
            vector<int> waterSupply(n, 0);
            if(arr[0] < h){
                waterSupply[0] = h - arr[0];
                days -= (h - arr[0]);
            }
            
            if(days < 0){
                return false;
            }
            
            for(int i = 1; i < arr.size(); i++){
                waterSupply[i] = waterSupply[i - 1];
                int actualHeight = arr[i];
                if(i >= cs){
                    actualHeight += (waterSupply[i] - waterSupply[i - cs]);
                }
                else{
                    actualHeight += waterSupply[i];
                }
                
                if(actualHeight < h){
                    waterSupply[i] += (h - actualHeight);
                    days -= (h - actualHeight);
                }
                if(days < 0){
                    return false;
                }
            }
            return true;
        }
  public:
    int maxMinHeight(vector<int> &arr, int k, int w) {
        // Q. Max min Height
        // code here
        int res = -1;
        int mnHeight = *min_element(arr.begin(), arr.end());
        int mxHeight = INT_MAX / 2;
        while(mnHeight <= mxHeight){
            int guessHeight = (mxHeight + mnHeight) / 2;
            if(isOK(arr, k, w, guessHeight) == true){
                res = guessHeight;
                mnHeight = guessHeight + 1;
            }
            else{
                mxHeight = guessHeight - 1;
            }
        }
        return res;
    }
};