class Solution(object):
    def countSubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        mem = [[False for i in xrange(len(s)+1)] for j in xrange(len(s))]
        for i in xrange(len(s)):
            mem[i][0] = True

        for i in xrange(len(s)):
            mem[i][1] = True
        count = len(s)
        for i in xrange(2,len(s)+1):
            for j in xrange(0,len(s)-i+1):
                start = j
                end = j+i-1
                if mem[start+1][i-2] and s[start] == s[end]:
                    mem[start][i] = True
                    count += 1
        return count

if __name__ == '__main__':
    s = Solution()
    print s.countSubstrings("abc")




