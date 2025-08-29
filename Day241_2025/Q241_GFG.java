class Q241_GFG {
    public static String smallestWindow(String s, String p) {
        int[] freqs = new int[26];
        int[] freqp = new int[26];
        int unique = 0;
        
        for (char ch : p.toCharArray()) {
            if (freqp[ch - 'a'] == 0) unique++;
            freqp[ch - 'a']++;
        }
        
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, match = 0;
        String ans = "";
        
        while (end < s.length()) {
            freqs[s.charAt(end) - 'a']++;
            
            if (freqs[s.charAt(end) - 'a'] == freqp[s.charAt(end) - 'a'] 
                && freqp[s.charAt(end) - 'a'] > 0) {
                match++;
            }
            
            if (match >= unique) {
                while (start <= end && freqs[s.charAt(start) - 'a'] > freqp[s.charAt(start) - 'a']) {
                    freqs[s.charAt(start) - 'a']--;
                    start++;
                }
                
                int len = end - start + 1;
                if (len < minLen) {
                    minLen = len;
                    ans = s.substring(start, end + 1);
                }
            }
            end++;
        }
        return ans;
    }
}
