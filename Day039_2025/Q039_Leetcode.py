import heapq

class NumberContainers:
    def __init__(self):
        self.indexToNumbers = {}
        self.numberToIndices = {}

    def change(self, index: int, number: int) -> None:
        # Update the mapping of index to number
        self.indexToNumbers[index] = number
        
        # Ensure the number has a min-heap
        if number not in self.numberToIndices:
            self.numberToIndices[number] = []
        
        # Add the index to the heap of the corresponding number
        heapq.heappush(self.numberToIndices[number], index)

    def find(self, number: int) -> int:
        if number not in self.numberToIndices:
            return -1
        
        min_heap = self.numberToIndices[number]
        
        # Ensure the top index is still mapped to this number
        while min_heap:
            index = min_heap[0]
            if self.indexToNumbers.get(index) == number:
                return index
            heapq.heappop(min_heap)  # Remove outdated indices
        
        return -1

# Your NumberContainers object will be instantiated and called as such:
# obj = NumberContainers()
# obj.change(index, number)
# param_2 = obj.find(number)
