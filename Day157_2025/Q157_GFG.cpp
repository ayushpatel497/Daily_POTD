class Solution {
  public:
    vector<int> search(string &pattern, string &text) {
        // Q. Search Pattern (Rabin-Karp Algorithm)
        // code here.
        vector<int> res;
        int q = 101;
        int d = 26;
        int M = pattern.size();  
        int N = text.size();  
        int i, j, p = 0, t = 0, h = 1;  
        for (i = 0; i < M - 1; i++)  
            h = (h * d) % q;  
        for (i = 0; i < M; i++){  
            p = (d * p + pattern[i]) % q;  
            t = (d * t + text[i]) % q;  
        }  
        for (i = 0; i <= N - M; i++){  
            if ( p == t ){  
                for (j = 0; j < M; j++)  
                    if (text[i+j] != pattern[j])  
                        break;  
                if (j == M)  
                    res.push_back(i+1);  
            }  
            if ( i < N-M ){  
                t = (d*(t - text[i]*h) + text[i+M])%q;  
                if (t < 0)  
                    t = (t + q);  
            }  
        }  
        return res;
    }
};