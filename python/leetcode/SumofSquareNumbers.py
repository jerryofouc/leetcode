

class Solution(object):
    def judgeSquareSum(self, c):
        """
        :type c: int
        :rtype: bool
        """
        if c==0:
            return True
        for i in xrange(0,c/2+1):
            import math
            if c - i*i>0 and int(math.sqrt(c - i*i))**2 == c-i*i:
                return True

        return False


if __name__ == '__main__':
    s = Solution()
    print s.judgeSquareSum(6)

