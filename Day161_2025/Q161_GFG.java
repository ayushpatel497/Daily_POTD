class Q161_GFG {
    int countStrings(String s) {
        int[] arr = new int[256];
        int count = 0;
        boolean flag = false;

        for (int i = 0; i < s.length(); i++) {
            count += s.length() - i - 1;
            count -= arr[s.charAt(i)];
            if (arr[s.charAt(i)] != 0) flag = true;
            arr[s.charAt(i)]++;
        }

        return count + (flag ? 1 : 0);
    }
}
