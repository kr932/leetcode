class Solution{
public String makeSmallestPalindrome(String s) {
    char[] a = s.toCharArray();
    int n = a.length;
    for (int i = 0; i < n/2; i++) {
        int j = n - 1 - i;
        if (a[i] != a[j]) {
            char c = (a[i] < a[j]) ? a[i] : a[j];
            a[i] = c;
            a[j] = c; // actually only one of these is a real change
        }
    }
    return new String(a);
}
}
