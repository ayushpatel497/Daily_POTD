class Q172_GFG {
    public int catchThieves(char[] arr, int k) {
        int n = arr.length;
        int i = 0, j = 0, ans = 0;
        
        while (i < n && j < n) {
            if (arr[i] == 'T' && arr[j] == 'P') {
                if (Math.abs(i - j) <= k) {
                    ans++;
                    i++;
                    j++;
                } else {
                    if (i < j) i++;
                    else j++;
                }
            } else {
                while (i < n && arr[i] == 'P') i++;
                while (j < n && arr[j] == 'T') j++;
            }
        }

        return ans;
    }
}
