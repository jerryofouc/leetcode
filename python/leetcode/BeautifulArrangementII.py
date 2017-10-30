class Solution(object):
    def constructArray(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[int]
        """
        array = [0 for i in xrange(n)]
        array[k] = k+1
        array[k-1] = 1
        temp = [False for i in xrange(k+1)]
        temp[k] = True
        temp[0] = True
        diff = k-1
        last = 1
        for i in reversed(xrange(0,k-1)):
            if last+diff < k+1 and not temp[last+diff-1]:
                array[i] = last+diff
                temp[last+diff-1] = True
            else:
                array[i] = last-diff
                temp[last-diff-1] = True
            last = array[i]
            diff -= 1

        for i in xrange(k+1,n):
            array[i] = i+1
        return array


if __name__ == '__main__':
    s = Solution()
    print s.constructArray(2,1)

