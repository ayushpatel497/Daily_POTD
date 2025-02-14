class Solution:
    def getWrongNodes(self, root, first, middle, last, prev):
        if root is None:
            return
        
        self.getWrongNodes(root.left, first, middle, last, prev)
        
        if prev and root.data < prev.data:
            if first is None:
                first = prev
                middle = root
            else:
                last = root
                
        prev = root
        self.getWrongNodes(root.right, first, middle, last, prev)
    
    def correctBST(self, root):
        first, middle, last, prev = None, None, None, None
        self.getWrongNodes(root, first, middle, last, prev)
        
        if first and last:
            # Swap the data of the first and last nodes
            first.data, last.data = last.data, first.data
        elif first and middle:
            # Swap the data of the first and middle nodes
            first.data, middle.data = middle.data, first.data
