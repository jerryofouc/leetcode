class Solution(object):
    def solveEquation(self, equation):
        """
        :type equation: str
        :rtype: str
        """
        e = equation.split("=")
        left = e[0]
        right = e[1]
        left_tuple = self.get_value(left)
        right_tuple = self.get_value(right)
        left_tuple[0] = left_tuple[0]-right_tuple[0]
        left_tuple[1] = right_tuple[1] - left_tuple[1]
        if left_tuple[0] == 0 and left_tuple[1]==0:
            return "Infinite solutions"
        elif left_tuple[0] == 0:
            return "No solution"
        else:
            return "x="+str(left_tuple[1]/left_tuple[0])
    def get_value(self,exp):
        result = [0,0]
        if exp[0] != '+' and exp[0] != '-':
            exp = "+" + exp
        i = 0
        while i < xrange(len(exp)):
            j = i+1
            if j>=len(exp):
                break
            while j<len(exp) and exp[j] != '-' and exp[j] != '+':
                j += 1
            if exp[j-1] == 'x':
                a = exp[i:j-1]
                if len(a) == 1:
                    a += "1"
                result[0] += int(a)
            else:
                result[1] += int(exp[i:j])
            i = j
        return result

if __name__ == '__main__':
    s = Solution()
    print s.solveEquation("x=x+2")



