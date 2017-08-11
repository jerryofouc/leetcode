class Solution(object):
    def findMaxAverage(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: float
        """
        temp = sum(nums[:k])
        max_sum = temp
        for i in xrange(k,len(nums)):
            temp1 = temp+nums[i]-nums[i-k]
            max_sum = max(temp1,max_sum)
            temp = temp1

        return max_sum/(k*1.0)


if __name__ == '__main__':
    s = Solution()
    print s.findMaxAverage([0,4,0,3,2],1)

