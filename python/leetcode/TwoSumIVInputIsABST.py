# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
import collections
from get_tree import build_tree


class Solution(object):
    def findTarget(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: bool
        """
        def tra(root):
            if not root:
                return
            counter[root.val]+=1
            tra(root.left)
            tra(root.right)

        counter = collections.Counter()
        tra(root)
        for item,count in counter.items():
            next = k-item
            if next == item:
                if counter[next]>1:
                    return True
            else:
                c = counter[next]
                if c>0:
                    return True
        return False

if __name__ == '__main__':
    s = Solution()
    root = build_tree([1])
    print s.findTarget(root,2)








