//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

// User function template for C++
class Trie {
    struct TrieNode {
        unordered_map<char, TrieNode*> children;
        bool isEndOfWord;
        TrieNode(){
            isEndOfWord = false;
        }
    };
    TrieNode* root;
  public:

    Trie() {
        // Q. Implement Trie
        root = new TrieNode();
    }

    void insert(string &word) {
        // insert word into Trie
        TrieNode* cur = root;
        for(char z : word){
            if(cur->children.find(z) == cur->children.end())
                cur->children[z] = new TrieNode();
            cur = cur->children[z];
            
        }
        cur->isEndOfWord = true;
    }

    bool search(string &word) {
        // search word in the Trie
        TrieNode* cur = root;
        for(char z : word){
            if(cur->children.find(z) == cur->children.end())
                return false;
            cur = cur->children[z];   
        }
        return cur->isEndOfWord;
    }

    bool isPrefix(string &word) {
        // search prefix word in the Trie
        TrieNode* cur = root;
        for(char z : word){
            if(cur->children.find(z) == cur->children.end())
                return false;
            cur = cur->children[z];     
        }
        return true;
    }
};



//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        int q;
        cin >> q;
        cin.ignore();
        vector<bool> ans;
        Trie ob;
        for (int i = 0; i < q; i++) {
            int x;
            cin >> x;
            string s;
            cin >> s;
            cin.ignore();
            if (x == 1) {
                ob.insert(s);
            } else if (x == 2) {
                ans.push_back(ob.search(s));
            } else if (x == 3) {
                ans.push_back(ob.isPrefix(s));
            }
        }
        cout << boolalpha;
        for (auto it : ans) {
            cout << it << " ";
        }
        cout << endl;
        cout << "~\n";
    }
    return 0;
}

// } Driver Code Ends