import java.util.*;

class Q259_Leetcode {
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        LinkedList<Integer> stack = new LinkedList<>();
        
        for (int num : nums) {
            while (!stack.isEmpty()) {
                int top = stack.peekLast();
                int g = gcd(top, num);
                if (g == 1) {
                    break;
                }
                stack.pollLast();
                long merged = (long) top / g * num;
                num = (int) merged;
            }
            stack.addLast(num);
        }
        
        return new ArrayList<>(stack);
    }
}
