import java.util.*;

class Q020_Leetcode {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        // Map to store the index of each element in the array `arr`
        Map<Integer, Integer> numToIndexMap = new HashMap<>();
        for (int index = 0; index < arr.length; index++) {
            numToIndexMap.put(arr[index], index);
        }

        int answer = Integer.MAX_VALUE;
        int numRows = mat.length;
        int numCols = mat[0].length;

        // Check each row for the first complete index
        for (int row = 0; row < numRows; row++) {
            int lastElementIndex = Integer.MIN_VALUE;
            for (int col = 0; col < numCols; col++) {
                int indexVal = numToIndexMap.get(mat[row][col]);
                lastElementIndex = Math.max(lastElementIndex, indexVal);
            }
            answer = Math.min(answer, lastElementIndex);
        }

        // Check each column for the first complete index
        for (int col = 0; col < numCols; col++) {
            int lastElementIndex = Integer.MIN_VALUE;
            for (int row = 0; row < numRows; row++) {
                int indexVal = numToIndexMap.get(mat[row][col]);
                lastElementIndex = Math.max(lastElementIndex, indexVal);
            }
            answer = Math.min(answer, lastElementIndex);
        }

        return answer;
    }
}
