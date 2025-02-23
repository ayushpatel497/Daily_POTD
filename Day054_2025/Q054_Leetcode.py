from typing import List, Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def constructTree(self, preorder: List[int], postorder: List[int], preIndex: List[int], postIndex: List[int]) -> Optional['TreeNode']:
        root = TreeNode(preorder[preIndex[0]])
        preIndex[0] += 1
        
        # If the root's value is not equal to the current postorder element,
        # it means there is a left subtree.
        if root.val != postorder[postIndex[0]]:
            root.left = self.constructTree(preorder, postorder, preIndex, postIndex)
        
        # If after processing left subtree, the root's value is still not equal
        # to the current postorder element, then there is a right subtree.
        if root.val != postorder[postIndex[0]]:
            root.right = self.constructTree(preorder, postorder, preIndex, postIndex)
        
        postIndex[0] += 1
        return root

    def constructFromPrePost(self, preorder: List[int], postorder: List[int]) -> Optional['TreeNode']:
        preIndex = [0]  # Using list to simulate pass-by-reference
        postIndex = [0]
        return self.constructTree(preorder, postorder, preIndex, postIndex)
