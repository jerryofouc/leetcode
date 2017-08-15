class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        result = []
        import bisect
        import math
        import collections
        index = bisect.bisect_right(arr,x)
        left = index-1
        right = index
        while k>0:
            if left>=0 and right<len(arr):
                if math.fabs(x-arr[left])<=math.fabs(x-arr[right]):
                    result.insert(0,arr[left])
                    left =left- 1
                else:
                    result.append(arr[right])
                    right += 1
            elif left>=0 :
                result.insert(0,arr[left])
                left =left- 1
            else:
                result.append(arr[right])
                right += 1
            k =k-1

        return result

if __name__ == '__main__':
    s = Solution()
    print s.findClosestElements([1,2,3,4,5],4,5)


