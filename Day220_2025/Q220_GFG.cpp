class Solution {
  public:
    int getLPSLength(string &s) {
        // Q. Longest Prefix Suffix
        // code here
        int n=s.size();
        
        for(int temp=n-1;temp>=1;temp--)
        {
            bool flag=true;
            for(int i=0;i<temp;i++)
            {
                if(s[i]!=s[n-temp+i])
                {
                    flag=false;
                    break;
                }
                
            }
            if(flag)
            {
                return temp;
            }
        }
        return 0;
    }
};