class Solution(object):
    def newInteger(self,n):
        add = self.newInteger1(n)
        nextN = n+add
        add1 = self.newInteger1(nextN)
        while add != add1:
            add = self.newInteger1(nextN)
            nextN = n+add
            add1 = self.newInteger1(nextN)

        return nextN
    def newInteger1(self, n):
        """
        :type n: int
        :rtype: int
        """
        k=1
        a = 0
        while n/k != 0:
            k*=10
            a += 1
        k = k/10

        map = {1:0}
        last = 0
        for i in xrange(1,a):
            map[10**i] = last*9 + 10**(i-1)
            last = map[10**i]
        sum = 0
        while n>0:
            t = n/k
            sum += t*map[k]
            if t == 9:
                 sum+= n%k+1
                 break
            n %= 10 ** (a-1)
            a -= 1
            k /= 10
        return sum




    def nextNot9(self,n):
        i = 0
        while True:
            k = n/(10**i)
            if k == 0:
                return n
            if k%10 == 9:
                k += 1
                n = k*(10**i)
            i += 1



if __name__ == '__main__':
    s = Solution()
    print s.newInteger(100)






