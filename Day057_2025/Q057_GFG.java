import java.util.*;

class Q057_GFG {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n, 0));
        Stack<Integer> s = new Stack<>();
        int[] len = new int[n];

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                int top = s.pop();
                int windowSize = s.isEmpty() ? i : i - s.peek() - 1;
                len[top] = windowSize;
            }
            s.push(i);
        }

        while (!s.isEmpty()) {
            int top = s.pop();
            int windowSize = s.isEmpty() ? n : n - s.peek() - 1;
            len[top] = windowSize;
        }

        for (int i = 0; i < n; i++) {
            int windowSize = len[i] - 1;
            res.set(windowSize, Math.max(res.get(windowSize), arr[i]));
        }

        for (int i = n - 2; i >= 0; i--)
            res.set(i, Math.max(res.get(i), res.get(i + 1)));

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] tokens = sc.nextLine().split(" ");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }
            Solution ob = new Solution();
            ArrayList<Integer> res = ob.maxOfMins(arr);
            for (int i : res)
                System.out.print(i + " ");
            System.out.println("\n~");
        }
        sc.close();
    }
}
