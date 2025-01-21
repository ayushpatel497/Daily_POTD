class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class Solution:
    def reverseKGroup(self, head, k):
        temporary = head
        previous_last = None
        
        while temporary:
            kth_node = self.get_kth_node(temporary, k)
            if not kth_node:
                if previous_last:
                    previous_last.next = temporary
                break
            
            next_node = kth_node.next
            kth_node.next = None
            
            self.reverse_list(temporary)
            
            if temporary == head:
                head = kth_node
            else:
                previous_last.next = kth_node
            
            previous_last = temporary
            temporary = next_node
        
        return head
    
    def get_kth_node(self, head, k):
        k -= 1
        while head and k > 0:
            head = head.next
            k -= 1
        return head
    
    def reverse_list(self, head):
        prev = None
        curr = head
        while curr:
            next_node = curr.next
            curr.next = prev
            prev = curr
            curr = next_node
