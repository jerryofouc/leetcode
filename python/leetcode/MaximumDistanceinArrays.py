import math


class Solution(object):
    def maxDistance(self, arrays):
        minArray = [(val[0],idx) for idx,val in enumerate(arrays)]
        maxArray = [(val[-1],idx) for idx,val in enumerate(arrays)]

        minArray = sorted(minArray,key=lambda a : a[0])
        maxArray = sorted(maxArray,key=lambda a : a[0])

        firstMin = minArray[0]
        secondMin = minArray[1]

        firstMax = maxArray[-1]
        secondMax = maxArray[-2]

        if firstMin[1] != firstMax[1]:
            return int(math.fabs(firstMax[0]-firstMin[0]))
        else:
            return int(max(math.fabs(firstMax[0]-secondMin[0]),math.fabs(secondMax[0]-firstMin[0])))



if __name__ == '__main__':
    a = [[1,4],[0,5]]
    s = Solution()
    print s.maxDistance(a)