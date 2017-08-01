class Solution(object):
    def kInversePairs(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: int
        """
        if n<1:
            return 0
        a = []
        for i in xrange(k+1):
            a.append(0)
        b = []
        for i in xrange(k+1):
            b.append(0)
        a[0] = 1
        for i in xrange(2,n+1):
            for j in xrange(0,k+1):
                if j == 0:
                    b[j] = 1
                else:
                    if j-i>=0:
                        b[j] = (a[j]+b[j-1]-a[j-i])%(10**9+7)
                    else:
                        b[j] = (b[j-1]+a[j])%(10**9+7)
            c = a
            a = b
            b = c
        return a[k]


if __name__ == '__main__':
    s = Solution()
    print s.kInversePairs(1000,1000)