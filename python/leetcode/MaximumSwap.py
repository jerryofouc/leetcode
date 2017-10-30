class Solution(object):
    def maximumSwap(self, num):
        """
        :type num: int
        :rtype: int
        """
        num_str = "%s" %num
        max_value = num
        for i in xrange(len(num_str)):
            for j in xrange(i,len(num_str)):
                tmp = list('%s' %num_str)
                t = tmp[i]
                tmp[i] = tmp[j]
                tmp[j] = t
                max_value = max(max_value,int("".join(tmp)))

        return max_value


if __name__ == '__main__':
    s = Solution()
    print s.maximumSwap(9973)