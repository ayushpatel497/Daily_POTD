class Solution {
public:
    int finalValueAfterOperations(vector<string>& operations) {
        // Q. Final Value of Variable After Performing Operations
        int x = 0;
        for (auto& op : operations) {
            if (op == "X++" || op == "++X") {
                x++;
            } else {
                x--;
            }
        }
        return x;
    }
};