import collections


class Solution(object):
    def isPossible(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        splits = collections.deque()
        for i in nums:
            found = False
            for split in splits:
                if split[-1] +1 == i:
                    split.append(i)
                    found = True
                    break
            if not found:
                splits.appendleft([i])
            temp = collections.deque()
            for x in splits:
                if x[-1]>=i-1:
                    temp.append(x)
                else:
                    if len(x) < 3:
                        return False
            splits = temp

        for split in splits:
            if len(split) < 3:
                return False

        return True


if __name__ == '__main__':
    s = Solution()
    print s.isPossible([1,3,3,4,4,7,8,8,9,10])
