class Solution(object):
    def minSteps(self, n):
        """
        :type n: int
        :rtype: int
        """

        mem = [0 for i in xrange(n+1)]
        for i in xrange(2,n+1):
            j = i-1
            mem[i] = i
            while j > 1:
                if i%j == 0:
                    mem[i] = mem[j] + i/j
                    break
                j-=1
        return mem[n]


if __name__ == '__main__':
    s = Solution()
    print s.minSteps(4)