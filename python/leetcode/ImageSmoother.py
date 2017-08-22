class Solution(object):
    def imageSmoother(self, M):
        """
        :type M: List[List[int]]
        :rtype: List[List[int]]
        """
        new_m = [[0 for i in xrange(len(M[0]))] for j in xrange(len(M))]

        for i in xrange(len(new_m)):
            for j in xrange(len(new_m[0])):
                sum = 0
                count = 0
                for k in xrange(-1,2):
                    for p in xrange(-1,2):
                        if 0 <= i+k < len((new_m)):
                            if 0<=j+p<len((new_m[0])):
                                sum += M[i+k][j+p]
                                count += 1

                new_m[i][j] = sum/count

        return new_m



if __name__ == '__main__':
    s = Solution()
    s.imageSmoother([[2,3,4],[5,6,7],[8,9,10],[11,12,13],[14,15,16]])