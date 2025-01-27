//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// design the class in the most optimal way

class LRUCache {
  private:
  public:
    class Node{
      public:
        int key;
        int value;
        Node *prev;
        Node *next;
        Node(int k, int v){
            key = k;
            value = v;
            prev = nullptr;
            next = nullptr;
        }
    };
    
    int n;
    unordered_map<int, Node*> mp;
    Node *head = new Node(-1, -1);
    Node *tail = new Node(-1, -1);
    
    // Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap) {
        // Q. LRU Cache
        // code here
        n = cap;
        head -> next = tail;
        tail -> prev = head;
    }

    // Function to return value corresponding to the key.
    int get(int key) {
        // your code here
        if(mp.count(key)){
            Node* temp = mp[key];
            remove(temp);
            insert(temp);
            return temp -> value;
        }
        return -1;
    }
    
    void remove(Node *node){
        mp.erase(node -> key);
        Node *prevv = node -> prev;
        Node *nextt = node -> next;
        prevv -> next = nextt;
        nextt -> prev = prevv;
    }
    
    void insert(Node *node){
        mp[node -> key] = node;
        Node *temp = head -> next;
        head -> next = node;
        node -> next = temp;
        temp -> prev = node;
        node -> prev = head;
    }
    // Function for storing key-value pair.
    void put(int key, int value) {
        // your code here
        Node *newNode = new Node(key, value);
        if(mp.count(key)){
            remove(mp[key]);
        }
        if(mp.size() == n){
            remove(tail -> prev);
        }
        insert(newNode);
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {

        int capacity;
        cin >> capacity;
        LRUCache *cache = new LRUCache(capacity);

        int queries;
        cin >> queries;
        while (queries--) {
            string q;
            cin >> q;
            if (q == "PUT") {
                int key;
                cin >> key;
                int value;
                cin >> value;
                cache->put(key, value);
            } else {
                int key;
                cin >> key;
                cout << cache->get(key) << " ";
            }
        }
        cout << endl;
        cout << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends