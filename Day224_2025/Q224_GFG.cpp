class Solution {
  public:
    vector<int> minMaxCandy(vector<int>& prices, int k) {
        // Q. Shop in Candy Store
        // Code here
        vector<int> ans;
        int elementUsed = 0;
        int totalSum = 0;
        sort(prices.begin(), prices.end());
        int start = 0;
        while(elementUsed < prices.size()){
            totalSum += prices[start];
            if(k == 0){
                elementUsed += 1;
            }
            else{
                elementUsed = elementUsed + k + 1;
            }
            start++;
        }
        ans.push_back(totalSum);
        elementUsed = 0;
        int end = prices.size() - 1;
        totalSum = 0;
        while(elementUsed < prices.size())
        {
            totalSum += prices[end];
            if(k == 0){
                elementUsed += 1;
            }
            else{
                elementUsed = k + elementUsed + 1;
            }
            end--;
        }
        ans.push_back(totalSum);
        return ans;
    }
};