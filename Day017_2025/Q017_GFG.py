class Solution:
    def productExceptSelf(self, arr):
        # Q. Product array puzzle
        n = len(arr)
        products = [1] * n

        preProduct = 1
        for i in range(n):
            products[i] *= preProduct
            preProduct *= arr[i]

        postProduct = 1
        for i in range(n - 1, -1, -1):
            products[i] *= postProduct
            postProduct *= arr[i]

        return products


if __name__ == "__main__":
    t = int(input("Enter the number of test cases: "))

    for _ in range(t):
        arr = list(map(int, input("Enter the array elements separated by space: ").split()))

        sol = Solution()
        result = sol.productExceptSelf(arr)

        print("Result:")
        print(" ".join(map(str, result)))
        print("~")
