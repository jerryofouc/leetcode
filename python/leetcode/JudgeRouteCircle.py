class Solution(object):
    def judgeCircle(self, moves):
        """
        :type moves: str
        :rtype: bool
        """
        dict = {"U":(0,1),"D":(0,-1),"R":(1,0),"L":(-1,0)}
        target = [0,0]
        for m in moves:
            target[0] += dict[m][0]
            target[1] += dict[m][1]

        return target[0] == 0 and target[1] == 0



if __name__ == '__main__':
    s = Solution()
    print s.judgeCircle("LL")