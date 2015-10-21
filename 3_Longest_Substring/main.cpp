class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        map<char, int>  S_map;
        map<char, int>::iterator iter;
        int L = 0, L_min = -1;
        for (int i = 0; i != s.length(); i++)
        {
            iter = S_map.find(s[i]); 
            if(iter != S_map.end() && iter->second > L_min)
            {
                L_min = iter->second;
            }
            L = (i - L_min) > L ? (i - L_min) : L;
            S_map[s[i]] = i;
        }
        return L;
    }
};
