class Solution {
    struct TrieNode {
        TrieNode* children[26];
        int count;
        TrieNode() {
            count = 0;
            for (int i = 0; i < 26; ++i)
                children[i] = nullptr;
        }
    };
  public:
    vector<string> findPrefixes(vector<string>& arr) {
        // Q. Shortest Unique Prefix for Every Word
        // code here
        TrieNode* root = new TrieNode();
        for (const string& s : arr) {
            TrieNode* curr = root;
            for (char c : s) {
                int idx = c - 'a';
                if (!curr->children[idx])
                    curr->children[idx] = new TrieNode();
                curr = curr->children[idx];
                curr->count++;
            }
        }
        vector<string> result;
        for (const string& s : arr) {
            TrieNode* curr = root;
            string prefix = "";
            for (char c : s) {
                int idx = c - 'a';
                curr = curr->children[idx];
                prefix += c;
                if (curr->count == 1)
                    break;
            }
            result.push_back(prefix);
        }
        return result;
    }
};