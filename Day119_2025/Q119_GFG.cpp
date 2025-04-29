//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

/* Link list Node */
class Node {
  public:
    int data;
    Node* next;

    Node(int x) {
        data = x;
        next = nullptr;
    }
};

void printList(Node* node) {
    while (node != NULL) {
        cout << node->data << " ";
        node = node->next;
    }
    cout << "\n";
}

void freeList(struct Node* head) {
    struct Node* temp;
    while (head != NULL) {
        temp = head;
        head = head->next;
        delete temp;
    }
}


// } Driver Code Ends

/*

  Node is defined as
  struct Node {
    int data;
    struct Node *next;
    Node(int x) {
        data = x;
        next = NULL;
    }
};

*/
class Solution {
  public:
    // Function to sort a linked list of 0s, 1s and 2s.
    Node* segregate(Node* head) {
        // Q. Sort a linked list of 0s, 1s and 2s
        // code here
        if (!head || !(head->next))
            return head;
    
        // Create three dummy nodes to point to the beginning of
        // three linked lists. These dummy nodes are created to
        // avoid null checks.
        Node *zeroD = new Node(0);
        Node *oneD = new Node(0);
        Node *twoD = new Node(0);
    
        // Initialize current pointers for three lists
        Node *zero = zeroD, *one = oneD, *two = twoD;
    
        // Traverse the list
        Node *curr = head;
        while (curr != NULL) {
            if (curr->data == 0) {
              
                // If the data of the current node is 0,
                // append it to pointer zero and update zero
                zero->next = curr;
                zero = zero->next;
            }
            else if (curr->data == 1) {
              
                // If the data of the current node is 1,
                // append it to pointer one and update one
                one->next = curr;
                one = one->next;
            }
            else {
              
                // If the data of the current node is 2,
                // append it to pointer two and update two
                two->next = curr;
                two = two->next;
            }
            curr = curr->next;
        }
    
        // Combine the three lists
        if (oneD->next) 
            zero->next = oneD->next;
        else
            zero->next = twoD->next;
      
        one->next = twoD->next;
        two->next = nullptr;
    
        // Updated head
        head = zeroD->next;
        return head;
    }
};



//{ Driver Code Starts.

// Driver program to test above functions
int main() {
    int t, k;
    cin >> t;
    cin.ignore(); // Ignore the newline character after t

    while (t--) {
        string input;
        getline(cin, input); // Read the entire line for the array elements

        stringstream ss(input);
        Node *head = nullptr, *tail = nullptr;
        int x;

        if (ss >> x) {
            head = new Node(x);
            tail = head;

            while (ss >> x) {
                tail->next = new Node(x);
                tail = tail->next;
            }

            // Link the last node to the head if k is 1 to make it circular
            if (k == 1) {
                tail->next = head;
            }
        }

        Solution ob;
        Node* newHead = ob.segregate(head);
        printList(newHead);
        cout << "~" << endl;
    }

    return 0;
}
// } Driver Code Ends