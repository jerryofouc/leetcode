class Solution(object):
    def strangePrinter(self, s):
        if len(s) == 0:
            return 0
        dp = [[0 for i in range(len(s))] for j in range(len(s))]
        for i in range(len(s)):
            dp[i][i] = 1

        for l in range(2,len(s)+1):
            for i in range(0,len(s)-l+1):
                cur = 1 + dp[i+1][i+l-1]
                for j in range(i+1,i+l):
                    if s[i] == s[j]:
                        if i+1>j-1:
                            a = 0
                        else:
                            a = dp[i+1][j-1]
                        cur = min(cur,a+dp[j][i+l-1])
                    dp[i][i+l-1] = cur

        return dp[0][len(s)-1]




if __name__ == '__main__':
    s = Solution()
    print s.strangePrinter("abtatb")





