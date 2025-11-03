class Solution {
public:
    int minCost(string colors, vector<int>& neededTime) {
        // Q. Minimum Time to Make Rope Colorful
        int answer = 0;
        int colorsSize = colors.size();
        for(int colorIndex = 1; colorIndex < colorsSize; ++colorIndex){
            if(colors[colorIndex] == colors[colorIndex - 1]){
                answer += min(neededTime[colorIndex], neededTime[colorIndex - 1]);
                neededTime[colorIndex] = max(neededTime[colorIndex], neededTime[colorIndex - 1]);
            }
        }
        return answer;
    }
};