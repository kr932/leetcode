//Since the forward loop is more efficient, the recurrence used
// here is different from the recursive version
#pragma GCC optimize("O3", "unroll-loops")
int longestCommonSubsequence(char* text1, char* text2) {
    int n=strlen(text1), m=strlen(text2);
    int dp [2][1001]={0};
    for (register int i=1; i<=n; i++) {
        for (register int j=1; j<=m; j++) {
            if (text1[i-1]==text2[j-1]) 
                dp[i&1][j]=1+dp[(i-1)&1][j-1];
            else 
                dp[i&1][j]=(dp[(i-1)&1][j]>dp[i&1][j-1])?dp[(i-1)&1][j]:dp[i&1][j-1];
        }
    }
    return dp[n&1][m];
} 