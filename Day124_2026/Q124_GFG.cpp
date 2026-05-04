class Solution {
  public:
    int isPallindrome(long long int n) {
        // Q. Palindrome Binary
        // code here
        if(n % 2 == 0) return 0;
        string s = "";
        while(n){
            if(n % 2 == 0){
                s.push_back('0');
            }
            else{
                s.push_back('1');
            }
            n = n/2;
        }
        int  h = s.size() - 1, l = 0;
        if(s.size() == 1) return 1;
        while(l <= h){
            if(s[l] != s[h]) return 0;
            h--;
            l++;
        }
        return 1;
    }
};