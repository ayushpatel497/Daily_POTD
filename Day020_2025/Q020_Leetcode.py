from typing import List
class Solution:
    def firstCompleteIndex(self, arr: List[int], mat: List[List[int]]) -> int:
        # Map to store the index of each element in the array `arr`
        num_to_index = {num: index for index, num in enumerate(arr)}
        answer = float('inf')
        num_rows = len(mat)
        num_cols = len(mat[0])

        # Check each row for the first complete index
        for row in range(num_rows):
            last_element_index = float('-inf')
            for col in range(num_cols):
                index_val = num_to_index[mat[row][col]]
                last_element_index = max(last_element_index, index_val)
            answer = min(answer, last_element_index)

        # Check each column for the first complete index
        for col in range(num_cols):
            last_element_index = float('-inf')
            for row in range(num_rows):
                index_val = num_to_index[mat[row][col]]
                last_element_index = max(last_element_index, index_val)
            answer = min(answer, last_element_index)

        return answer