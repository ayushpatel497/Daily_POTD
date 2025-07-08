import java.util.*;

class Q189_GFG {
    public ArrayList<Integer> findGreater(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n, -1));
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && freq.get(arr[i]) > freq.get(arr[stack.peek()])) {
                res.set(stack.pop(), arr[i]);
            }
            stack.push(i);
        }

        return res;
    }
}
