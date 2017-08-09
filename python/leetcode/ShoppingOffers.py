class Solution(object):

    def shoppingOffers(self, price, special, needs):
        """
        :type price: List[int]
        :type special: List[List[int]]
        :type needs: List[int]
        :rtype: int
        """
        mem = {}
        return self.shopping_offers(price,special,tuple(needs),mem)

    def shopping_offers(self,price,special,needs_tuple,mem):
        if needs_tuple in mem:
            return mem[needs_tuple]
        cur = self.get_total(price,needs_tuple)
        for s in special:
            can_sub = True
            next_needs_tuple = list(needs_tuple)
            for i in xrange(len(needs_tuple)):
                if s[i]>needs_tuple[i]:
                    can_sub = False
                    break
                next_needs_tuple[i] = needs_tuple[i]-s[i]
            if can_sub:
                cur = min(cur,self.shopping_offers(price,special,tuple(next_needs_tuple),mem)+s[len(price)])
        mem[needs_tuple] = cur
        return cur

    def get_total(self, price, needs_tuple):
        total = 0
        for i in xrange(len(price)):
            total += price[i]*needs_tuple[i]
        return total


if __name__ == '__main__':
    s = Solution()
    print s.shoppingOffers([2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1])

