class Q145_GFG {
    boolean pythagoreanTriplet(int[] arr) {
        int maxEle = 0;

        for (int ele : arr)
            maxEle = Math.max(maxEle, ele);

        boolean[] vis = new boolean[maxEle + 1];
        for (int ele : arr)
            vis[ele] = true;

        for (int a = 1; a <= maxEle; a++) {
            if (!vis[a]) continue;

            for (int b = 1; b <= maxEle; b++) {
                if (!vis[b]) continue;

                int c2 = a * a + b * b;
                int c = (int)Math.sqrt(c2);

                if (c * c == c2 && c <= maxEle && vis[c]) {
                    return true;
                }
            }
        }

        return false;
    }
}
