//{ Driver Code Starts
#include <iostream>
#include <sstream>
#include <string>
#include <vector>
using namespace std;

/* Linked list Node */
struct Node {
    int data;
    struct Node* next;

    Node(int x) {
        data = x;
        next = NULL;
    }
};

Node* buildList() {
    vector<int> arr;
    string input;
    getline(cin, input);
    stringstream ss(input);
    int number;
    while (ss >> number) {
        arr.push_back(number);
    }
    if (arr.empty()) {
        return NULL;
    }
    int val = arr[0];
    int size = arr.size();

    Node* head = new Node(val);
    Node* tail = head;

    for (int i = 1; i < size; i++) {
        val = arr[i];
        tail->next = new Node(val);
        tail = tail->next;
    }

    return head;
}

void printList(Node* n) {
    while (n) {
        cout << n->data << " ";
        n = n->next;
    }
    cout << endl;
}


// } Driver Code Ends
/* node for linked list:

struct Node {
    int data;
    struct Node* next;
    Node(int x) {
        data = x;
        next = NULL;
    }
};

*/

class Solution {
  public:
    Node* addTwoLists(Node* num1, Node* num2) {
        // Q. Add Number Linked Lists
        // code here
        Node *rNum1 = reverseList(num1);
        Node *rNum2 = reverseList(num2);
        int carry = 0;
        Node *head = new Node(-1);
        Node *tail = head;
        while(rNum1 || rNum2 || carry){
            int operand1 = rNum1 ? rNum1 -> data : 0;
            int operand2 = rNum2 ? rNum2 -> data : 0;
            
            int sum = operand1 + operand2 + carry;
            int digit = sum % 10;
            carry = sum / 10;
            
            tail -> next = new Node(digit);
            tail = tail -> next;
            
            if(rNum1) rNum1 = rNum1 -> next;
            if(rNum2) rNum2 = rNum2 -> next;
        }
        
        head = reverseList(head -> next);
        while(head && head -> data == 0){
            head = head -> next;
        }
        
        return head;
    }
    
    Node* reverseList(Node* head){
        Node *prev = NULL;
        Node *curr = head;
        Node *next = head;
        while(curr){
            next = next -> next;
            curr -> next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    cin.ignore(); // To ignore the newline character after the integer input

    while (t--) {
        Node* num1 = buildList();
        Node* num2 = buildList();
        Solution ob;
        Node* res = ob.addTwoLists(num1, num2);
        printList(res);
        cout << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends