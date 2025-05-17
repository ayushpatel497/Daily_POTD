import java.util.*;

class Q137_GFG {
    private int evaluate(int x, int A, int B, int C) {
        return A * x * x + B * x + C;
    }

    public ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, 0));
        int left = 0, right = n - 1;
        int index = (A >= 0) ? n - 1 : 0;

        while (left <= right) {
            int leftVal = evaluate(arr[left], A, B, C);
            int rightVal = evaluate(arr[right], A, B, C);

            if (A >= 0) {
                if (leftVal > rightVal) {
                    result.set(index--, leftVal);
                    left++;
                } else {
                    result.set(index--, rightVal);
                    right--;
                }
            } else {
                if (leftVal < rightVal) {
                    result.set(index++, leftVal);
                    left++;
                } else {
                    result.set(index++, rightVal);
                    right--;
                }
            }
        }

        return result;
    }
}
