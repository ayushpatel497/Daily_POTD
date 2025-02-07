class Solution {
public:
    vector<int> queryResults(int limit, vector<vector<int>>& queries) {
        // Q. Find the Number of Distinct Colors Among the Balls
        int querySize = queries.size();
        vector<int> answer(querySize);
        unordered_map<int, int> colorMap, ballMap;
        for (int index = 0; index < querySize; ++index) {
            int ball = queries[index][0], color = queries[index][1];
            if (ballMap.count(ball)) {
                int prevColor = ballMap[ball];
                colorMap[prevColor]--;
                if (colorMap[prevColor] == 0){ 
                    colorMap.erase(prevColor);
                }    
            }
            ballMap[ball] = color;
            colorMap[color]++;
            answer[index] = colorMap.size();
        }

        return answer;
    }
};