class Solution:
    # Function to count the number of possible triangles.
    def countTriangles(self, arr):
        n = len(arr)
        arr.sort()  # Sort the array
        count = 0

        # Iterate for each pair (i, j)
        for i in range(n - 2):
            k = i + 2
            for j in range(i + 1, n - 1):
                # Find the maximum index k such that arr[i] + arr[j] > arr[k]
                while k < n and arr[i] + arr[j] > arr[k]:
                    k += 1
                if k > j:
                    count += k - j - 1

        return count


# Example Usage
if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        arr = list(map(int, input().split()))
        obj = Solution()
        print(obj.countTriangles(arr))
        print("~")
