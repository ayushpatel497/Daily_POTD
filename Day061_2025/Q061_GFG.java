import java.util.*;

class Q061_GFG {
    public ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            // Remove elements from the back if they are smaller than the current element
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
                dq.pollLast();
            }
            dq.addLast(i);

            // Remove elements from the front if they are out of the current window
            if (dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Add the maximum element of the window to the result
            if (i >= k - 1) {
                ans.add(arr[dq.peekFirst()]);
            }
        }
        
        return ans;
    }
}
