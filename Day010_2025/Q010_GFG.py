class Solution:
    def countDistinct(self, arr, k):
        # Q. Count distinct elements in every window
        from collections import defaultdict

        result = []
        freq_map = defaultdict(int)

        # Add the first k elements into the map
        for i in range(k):
            freq_map[arr[i]] += 1
        result.append(len(freq_map))

        # Process the remaining windows
        for i in range(k, len(arr)):
            # Add the current element
            freq_map[arr[i]] += 1
            # Remove the element that goes out of the window
            freq_map[arr[i - k]] -= 1
            if freq_map[arr[i - k]] == 0:
                del freq_map[arr[i - k]]
            result.append(len(freq_map))

        return result


# Example usage
if __name__ == "__main__":
    arr = [1, 2, 1, 3, 4, 2, 3]
    k = 4
    sol = Solution()
    print(sol.countDistinct(arr, k))
