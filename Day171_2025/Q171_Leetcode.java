class Q171_Leetcode {
    public int maxDistance(String s, int k) {
        int latitude = 0, longitude = 0, ans = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char dir = s.charAt(i);
            if (dir == 'N') latitude++;
            else if (dir == 'S') latitude--;
            else if (dir == 'E') longitude++;
            else if (dir == 'W') longitude--;

            int manhattan = Math.abs(latitude) + Math.abs(longitude);
            ans = Math.max(ans, Math.min(manhattan + k * 2, i + 1));
        }

        return ans;
    }
}
