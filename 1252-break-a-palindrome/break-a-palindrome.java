class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        
        // A single character palindrome cannot be made non-palindromic
        if (n == 1) return "";
        
        char[] chars = palindrome.toCharArray();
        
        // Try to change the first non-'a' character in the first half to 'a'
        for (int i = 0; i < n / 2; i++) {
            if (chars[i] != 'a') {
                chars[i] = 'a';
                return new String(chars);
            }
        }
        
        // If all characters in first half are 'a', change the last one to 'b'
        chars[n - 1] = 'b';
        return new String(chars);
    }
}
