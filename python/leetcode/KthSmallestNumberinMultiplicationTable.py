class Solution(object):
    def findKthNumber(self, m, n, k):
        """
        :type m: int
        :type n: int
        :type k: int
        :rtype: int
        """
        low = 1
        high = m*n+1
        while low < high:
            mid = low + (high-low)/2
            if self.count_num(mid,m,n) >= k:
                high = mid
            else:
                low = mid+1
        return high

    def count_num(self,mid,m,n):
        c = 0
        for i in xrange(1,n+1):
            c += min(m,mid/i)
        return c


if __name__ == '__main__':
    s = Solution()
    print s.findKthNumber(3,3,5)

