class Q230_GFG {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] freq = new int[n + 1];
        
        for (int c : citations) {
            if (c >= n) freq[n]++;
            else freq[c]++;
        }
        
        int idx = n;
        int s = freq[n];
        while (s < idx) {
            idx--;
            s += freq[idx];
        }
        return idx;
    }
}
