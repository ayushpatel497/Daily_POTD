class Solution {
public:
    int bitwiseComplement(int n) {
        // Q. Complement of Base 10 Integer
        if(!n) return 1;
        int help = 1;
        int ans = 0;
        while(n){
            int dig = n&1;
            ans += !dig*help;
            help<<=1;
            n>>=1;
        }
        return ans;
    }
};