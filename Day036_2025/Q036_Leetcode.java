class Q036_Leetcode {
    public boolean areAlmostEqual(String s1, String s2) {
        int countDifferences = 0;
        int firstDifferenceIndex = -1, secondDifferenceIndex = -1;
        
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                countDifferences++;
                
                if (countDifferences > 2) {
                    return false;
                } else if (countDifferences == 1) {
                    firstDifferenceIndex = i;
                } else {
                    secondDifferenceIndex = i;
                }
            }
        }
        
        return countDifferences == 0 || 
               (countDifferences == 2 && 
                s1.charAt(firstDifferenceIndex) == s2.charAt(secondDifferenceIndex) &&
                s1.charAt(secondDifferenceIndex) == s2.charAt(firstDifferenceIndex));
    }
}
