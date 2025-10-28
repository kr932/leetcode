class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] lps = new int[n]; // longest prefix-suffix array
        
        int len = 0; // length of the previous longest prefix-suffix
        int i = 1;
        
        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        // The value at lps[n-1] gives the length of longest happy prefix
        int longest = lps[n - 1];
        return s.substring(0, longest);
    }
}
