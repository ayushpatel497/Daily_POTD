class Solution {
  public:
    bool canServe(vector<int> &arr) {
        // Q. Bus Ticket Change
        // code here
        int n = arr.size();
        int five = 0, ten = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == 20){
                if(ten && five){
                    ten--;
                    five--;
                }
                else if(five >= 3){
                    five -= 3;
                }
                else return false;
            }
            else if(arr[i] == 10){
                ten++;
                if(five) five--;
                else return false;
            }
            else five++;
        }
        return true;
    }
};