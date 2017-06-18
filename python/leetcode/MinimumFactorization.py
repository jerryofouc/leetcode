class Solution(object):
    def smallestFactorization(self, a):
        """
        :type a: int
        :rtype: int
        """
        if a < 10:
            return a
        b = 1
        while True:
            should_break = True
            for i in reversed(xrange(2,10)):
                if a%i == 0:
                    b = b*10 + i
                    should_break = False
                    a = a/i
                    break
            if should_break:
                if a>10:
                    return 0
                break
        result = int(("%s" %b)[::-1])/10
        if result >= 2147483647:
            result = 0
        return result


if __name__ == '__main__':
    s = Solution()
    print s.smallestFactorization(18000000)




