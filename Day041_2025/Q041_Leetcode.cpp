class Solution {
    public:
        string clearDigits(string s) {
            // Q. Clear Digits
            string answer = "";
            for(auto character : s){
                if(character >= 'a' && character <= 'z'){
                    answer += character;
                }
                else if(character >= '0' && character <= '9'){
                    answer.pop_back();
                }
            }
            return answer;
        }
    };