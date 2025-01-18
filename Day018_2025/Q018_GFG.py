# Node class
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class Solution:
    def reverseList(self, head):
        # Q. Reverse a linked list
        prev = None
        curr = head

        while curr:
            next_node = curr.next  # Store the next node
            curr.next = prev       # Reverse the current node's pointer
            prev = curr            # Move prev to the current node
            curr = next_node       # Move to the next node

        return prev  # New head of the reversed list

# Helper function to print the list
def printList(head):
    temp = head
    while temp:
        print(temp.data, end=" ")
        temp = temp.next
    print()

# Driver code
if __name__ == "__main__":
    t = int(input("Enter the number of test cases: "))

    for _ in range(t):
        elements = list(map(int, input("Enter the linked list elements separated by space: ").split()))
        head = None
        tail = None

        for val in elements:
            if head is None:
                head = Node(val)
                tail = head
            else:
                tail.next = Node(val)
                tail = tail.next

        sol = Solution()
        head = sol.reverseList(head)

        print("Reversed List:")
        printList(head)
        print("~")
