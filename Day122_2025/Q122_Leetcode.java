class Q122_Leetcode {
    public String pushDominoes(String dominoes) {
        int N = dominoes.length();
        int[] forces = new int[N];
        int force = 0;

        // Left to right
        for (int i = 0; i < N; i++) {
            if (dominoes.charAt(i) == 'R') {
                force = N;
            } else if (dominoes.charAt(i) == 'L') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] += force;
        }

        // Right to left
        force = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L') {
                force = N;
            } else if (dominoes.charAt(i) == 'R') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] -= force;
        }

        // Build result string
        StringBuilder result = new StringBuilder();
        for (int f : forces) {
            if (f > 0) result.append('R');
            else if (f < 0) result.append('L');
            else result.append('.');
        }
        return result.toString();
    }
}
