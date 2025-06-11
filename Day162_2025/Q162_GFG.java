import java.util.*;

class Q162_GFG {
    public int findLength(int[] color, int[] radius) {
        Stack<int[]> stack = new Stack<>();
        int n = color.length;

        stack.push(new int[]{color[0], radius[0]});

        for (int i = 1; i < n; i++) {
            if (!stack.isEmpty()) {
                int[] top = stack.peek();
                if (top[0] == color[i] && top[1] == radius[i]) {
                    stack.pop();  // remove matching pair
                    continue;
                }
            }
            stack.push(new int[]{color[i], radius[i]});
        }

        return stack.size();
    }
}
