class Solution {
public:
    int longestBalanced(string s) {
        // Q. Longest Balanced Substring II
        int n = s.length(), m = 0;
        if (n == 0) return 0;
        
        int t = 1;
        for (int i = 1; i < n; i++) {
            if (s[i] == s[i - 1]) t++;
            else { m = max(m, t); t = 1; }
        }
        m = max(m, t);

        char v[3][2] = {{'a', 'b'}, {'a', 'c'}, {'b', 'c'}};
        char o[3] = {'c', 'b', 'a'};
        vector<int> d(200005, -2);
        for (int i = 0; i < 3; i++) {
            char x = v[i][0], y = v[i][1], z = o[i];
            int b = 0;
            while (b < n) {
                while (b < n && s[b] == z) b++;
                if (b == n) break;
                int e = b, c = 0;
                d[100000] = b - 1;
                while (e < n && s[e] != z) {
                    if (s[e] == x) c++; else if (s[e] == y) c--;
                    if (d[c + 100000] != -2) m = max(m, e - d[c + 100000]);
                    else d[c + 100000] = e;
                    e++;
                }
                int k = 0;
                d[100000] = -2;
                for (int j = b; j < e; j++) {
                    if (s[j] == x) k++; else if (s[j] == y) k--;
                    d[k + 100000] = -2;
                }
                b = e;
            }
        }

        unordered_map<long long, int> u;
        u.reserve(n);
        int a = 0, b = 0, c = 0;
        u[0] = -1;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'a') a++; else if (s[i] == 'b') b++; else c++;
            long long k = ((long long)(a - b) << 32) | (unsigned int)(b - c);
            auto it = u.find(k);
            if (it != u.end()) m = max(m, i - it->second);
            else u.emplace(k, i);
        }

        return m;
    }
};