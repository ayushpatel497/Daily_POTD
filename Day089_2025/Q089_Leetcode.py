from typing import List

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        partition_sizes = []
        last_occurrence = {char: i for i, char in enumerate(s)}  # Step 1: Store last occurrence
        
        partition_start = partition_end = 0
        for i, char in enumerate(s):
            partition_end = max(partition_end, last_occurrence[char])

            # If we reach the end of a partition
            if i == partition_end:
                partition_sizes.append(partition_end - partition_start + 1)
                partition_start = i + 1

        return partition_sizes

# Example Usage
sol = Solution()
print(sol.partitionLabels("ababcbacadefegdehijhklij"))  # Example Output: [9,7,8]
