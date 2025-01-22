class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class Solution:
    def addTwoLists(self, num1, num2):
        rNum1 = self.reverseList(num1)
        rNum2 = self.reverseList(num2)

        carry = 0
        dummy_head = Node(-1)
        tail = dummy_head

        while rNum1 or rNum2 or carry:
            operand1 = rNum1.data if rNum1 else 0
            operand2 = rNum2.data if rNum2 else 0

            total = operand1 + operand2 + carry
            digit = total % 10
            carry = total // 10

            tail.next = Node(digit)
            tail = tail.next

            if rNum1:
                rNum1 = rNum1.next
            if rNum2:
                rNum2 = rNum2.next

        result = self.reverseList(dummy_head.next)

        # Remove leading zeros
        while result and result.data == 0:
            result = result.next

        return result

    def reverseList(self, head):
        prev, curr = None, head
        while curr:
            next_node = curr.next
            curr.next = prev
            prev = curr
            curr = next_node
        return prev
