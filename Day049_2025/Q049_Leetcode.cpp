class Solution {
    int buildSequence(int currentIndex, int currentCount, string pattern, string &answer){
        if(currentIndex != pattern.size()){
            if(pattern[currentIndex] == 'I'){
                buildSequence(currentIndex + 1, currentIndex + 1, pattern, answer);
            }
            else{
                currentCount = buildSequence(currentIndex + 1, currentCount, pattern, answer);
            }
        }
        answer += to_string(currentCount + 1);
        return currentCount + 1;
    }
public:
    string smallestNumber(string pattern) {
        // Q. Construct Smallest Number From DI String
        string answer = "";
        buildSequence(0, 0, pattern, answer);
        reverse(answer.begin(), answer.end());
        return answer;
    }
};