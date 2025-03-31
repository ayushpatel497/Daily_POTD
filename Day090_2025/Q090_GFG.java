class Q090_GFG {
    public int maxPartitions(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        int count = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Q090_GFG sol = new Q090_GFG();
        System.out.println(sol.maxPartitions("abacbc")); // Expected Output: 3
    }
}
