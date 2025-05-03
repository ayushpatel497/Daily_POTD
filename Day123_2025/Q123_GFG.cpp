//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

class Node {
  public:
    int val;
    Node* next;

    Node(int x) {
        val = x;
        next = NULL;
    }
};

void printList(Node* node) {
    while (node != NULL) {
        cout << node->val << " ";
        node = node->next;
    }
    cout << "\n";
}


// } Driver Code Ends

// User function Template for C++

/*
class Node{
public:
    int val;
    Node *next;
    Node(int num){
        val=num;
        next=NULL;
    }
};
*/

class Solution {
    vector<int> findPrimes(int n) {
        vector<int> primes(n + 1, 1);
        primes[0] = 0;
        primes[1] = 0;
        for (int i = 2; i * i <= n; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = 0;
                }
            }
        }
        return primes;
    }

  public:
    Node *primeList(Node *head) {
        // Q. Prime List
        // code here
        int max_num = 0;
        Node* temp = head;
        while (temp != NULL) {
            max_num = max(max_num, temp->val);
            temp = temp->next;
        }
    
        vector<int> primes = findPrimes(2 * max_num);
        
        temp = head;
        while (temp != NULL) {
            int num = temp->val;
            
            if (num == 1) {
                temp->val = 2;
            } else {
                int num1 = num, num2 = num;
                while (!primes[num1]) {
                    num1--;
                }
                while (!primes[num2]) {
                    num2++;
                }
                
                if (num - num1 > num2 - num) {
                    temp->val = num2;
                } else {
                    temp->val = num1;
                }
            }
            
            temp = temp->next;
        }
        
        return head;
    }
};


//{ Driver Code Starts.

int main() {

    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        vector<int> arr;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }

        if (arr.empty()) {
            cout << -1 << endl;
            continue;
        }

        int data = arr[0];
        struct Node* head = new Node(data);
        struct Node* tail = head;
        for (int i = 1; i < arr.size(); ++i) {
            data = arr[i];
            tail->next = new Node(data);
            tail = tail->next;
        }

        Solution ob;
        head = ob.primeList(head);
        printList(head);
        cout << "~" << endl;
    }
    return 0;
}
// } Driver Code Ends