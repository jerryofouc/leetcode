class Solution(object):
    def findErrorNums(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        result = []
        temp = []
        for i in xrange(len(nums)):
            temp.append(0)
        for i in xrange(len(nums)):
            v = nums[i]
            if temp[v-1] != 0:
                result.append(v)
            else:
                temp[v-1] = v

        for i in xrange(len(temp)):
            if temp[i] == 0:
                result.append(i+1)
        return result


if __name__ == '__main__':
    s = Solution()
    print s.findErrorNums([1,2,2,4])