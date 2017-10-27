class Solution(object):
    def checkPossibility(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if len(nums) <=2:
            return True
        max_count = 0
        if nums[0]>nums[1]:
            max_count += 1
            nums[0] = nums[1]

        for i in xrange(2,len(nums)):
            if nums[i-1] > nums[i]:
                if max_count == 1:
                    return False
                else:
                    max_count += 1
                    if nums[i] >= nums[i-2]:
                        nums[i-1] = nums[i]
                    else:
                        nums[i] = nums[i-1]

        return True


if __name__ == '__main__':
    s = Solution()
    print s.checkPossibility([4,2,1])
