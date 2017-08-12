# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
import collections


class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
class Solution(object):
    def findDuplicateSubtrees(self, root):
        """
        :type root: TreeNode
        :rtype: List[TreeNode]
        """
        def trv(root):
            if not root:
                return "null"
            struct = "%s,%s,%s" % (str(root.val), trv(root.left), trv(root.right))
            nodes[struct].append(root)
            return struct
        nodes = collections.defaultdict(list)
        trv(root)
        return [nodes[struct][0] for struct in nodes if len(nodes[struct]) > 1]



if __name__ == '__main__':
    s = Solution()
    r = TreeNode(1)
    left = TreeNode(2)
    left_left = TreeNode(4)
    left.left = left_left
    right = TreeNode(3)
    r.left = left
    r.right = right
    right_left = TreeNode(2)
    right.left = right_left
    right_left_left = TreeNode(4)
    right_left.left = right_left_left
    right_right = TreeNode(4)
    right.right = right_right
    s.findDuplicateSubtrees(r)

