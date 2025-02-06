//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// Definition of the Node class
class Node {
  public:
    int data;
    Node *left;
    Node *right;

    Node(int x) {
        data = x;
        left = NULL;
        right = NULL;
    }
};

// Function to print the tree in postorder traversal
void printPostOrder(Node *root) {
    if (root == NULL)
        return;
    printPostOrder(root->left);
    printPostOrder(root->right);
    cout << root->data << " ";
}


// } Driver Code Ends
// Class that contains the logic to build the binary tree
/*
Definition of the Node class
class Node {
public:
    int data;
    Node *left;
    Node *right;

    Node(int x) {
        data = x;
        left = NULL;
        right = NULL;
    }
};
*/
class Solution {
  public:
    // Function to build the tree from given inorder and preorder traversals
    Node *buildTree(vector<int> &inorder, vector<int> &preorder) {
        // Q. Construct Tree from Inorder & Preorder
        // code here
        if (preorder.size() == 0 || inorder.size() == 0) return nullptr;
        int n = preorder.size();
        stack<Node*> stack;
        Node *root = new Node(preorder[0]);
        stack.push(root);
        int preIndex = 1, inIndex = 0;

        while (preIndex < n) {
            Node *currentNode = nullptr;
            while (!stack.empty() && stack.top() -> data == inorder[inIndex]) {
                currentNode = stack.top();
                stack.pop();
                inIndex++;
            }
            
            Node *newNode = new Node(preorder[preIndex]);

            if (currentNode != nullptr) {
                currentNode -> right = newNode;
            } else {
                stack.top() -> left = newNode;
            }

            stack.push(newNode);
            preIndex++;
        }

        return root;
    }
};

//{ Driver Code Starts.

// Main function where the test cases are handled
int main() {
    int t;
    cin >> t;
    cin.ignore();

    while (t--) {
        vector<int> inorder, preorder;

        // Input the inorder traversal
        string input;
        getline(cin, input);
        stringstream ss1(input);
        int num;
        while (ss1 >> num)
            inorder.push_back(num);

        // Input the preorder traversal
        getline(cin, input);
        stringstream ss2(input);
        while (ss2 >> num)
            preorder.push_back(num);

        // Create Solution object and build the tree
        Solution obj;
        Node *root = obj.buildTree(inorder, preorder);

        // Print the postorder traversal of the constructed tree
        printPostOrder(root);
        cout << endl;
        cout << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends