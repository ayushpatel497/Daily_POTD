import java.util.*;

class Q056_GFG {
    public static int getMaxArea(int arr[]) {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int res = 0;
        int tp;

        for (int i = 0; i < n; i++) {
            while (!s.empty() && arr[s.peek()] >= arr[i]) {
                tp = s.pop();
                int width = s.empty() ? i : i - s.peek() - 1;
                res = Math.max(res, arr[tp] * width);
            }
            s.push(i);
        }

        while (!s.empty()) {
            tp = s.pop();
            int width = s.empty() ? n : n - s.peek() - 1;
            res = Math.max(res, arr[tp] * width);
        }
        return res;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] tokens = input.split(" ");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }
            System.out.println(getMaxArea(arr));
            System.out.println("~");
        }
        sc.close();
    }
}
