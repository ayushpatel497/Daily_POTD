class Solution {
    public:
        string pushDominoes(string dominoes) {
            // Q. Push Dominoes
            int N = dominoes.length();
            vector<int> forces(N);
    
            // Populate forces going from left to right
            int force = 0;
            for (int i = 0; i < N; ++i) {
                if (dominoes[i] == 'R') force = N;
                else if (dominoes[i] == 'L') force = 0;
                else force = max(force - 1, 0);
                forces[i] += force;
            }
    
            // Populate forces going from right to left
            force = 0;
            for (int i = N-1; i >= 0; --i) {
                if (dominoes[i] == 'L') force = N;
                else if (dominoes[i] == 'R') force = 0;
                else force = max(force - 1, 0);
                forces[i] -= force;
            }
    
            string ans;
            for (int f: forces)
                ans += (f > 0 ? 'R' : f < 0 ? 'L' : '.');
            return ans;
        }
    };