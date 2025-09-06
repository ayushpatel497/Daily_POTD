class Solution:
    def lengthOfLoop(self, head):
        if not head or not head.next:
            return 0

        node_map = {}
        i = 1
        
        while head:
            if head in node_map:
                return i - node_map[head]
            node_map[head] = i
            i += 1
            head = head.next
            
        return 0
