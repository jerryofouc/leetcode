class Solution(object):
    def findLongestChain(self, pairs):
        """
        :type pairs: List[List[int]]
        :rtype: int
        """
        pairs = sorted(pairs,key=lambda key:key[0])
        result = []
        for i in xrange(len(pairs)):
            result.append(0)
        result[-1] = 1
        for i in xrange(len(pairs)-2,-1,-1):
            t = pairs[i]
            j = i+1
            while j<len(pairs) and t[1] >= pairs[j][0]:
                j += 1
            if j == len(pairs):
                result[i] = result[i+1]
            else:
                result[i] = max(result[i+1],1+result[j])
        return result[0]

if __name__ == '__main__':
    s = Solution()
    print s.findLongestChain([[3,4],[2,3],[1,2]])

