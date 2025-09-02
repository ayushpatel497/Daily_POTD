'''
class Node:
    def __init__(self, x):
        self.data = x
        self.next = None
'''
class Solution:
    def swapKth(self, head, k):
        if not head:
            return head

        # Step 1: Count length
        size = 0
        temp = head
        while temp:
            size += 1
            temp = temp.next

        k -= 1  # zero-based index
        start, end = k, size - k - 1
        node1, node2 = None, None

        temp = head
        cnt = 0
        while temp:
            if cnt == start:
                node1 = temp
            if cnt == end:
                node2 = temp
            temp = temp.next
            cnt += 1

        if node1 and node2:
            node1.data, node2.data = node2.data, node1.data

        return head
