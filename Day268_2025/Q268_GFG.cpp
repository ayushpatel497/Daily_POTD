class Solution {
  public:
    vector<string> generateBinary(int n) {
        // Q. Generate Binary Numbers
        // code here
        vector<string> res;
        queue<string> q;

        q.push("1");
        while (n--) {
            string s1 = q.front();
            q.pop();
            res.push_back(s1);

            string s2 = s1;
            q.push(s1.append("0"));
            q.push(s2.append("1"));
        }
        return res;
    }
};