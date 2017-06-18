# Definition for a binary tree node.


class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def addOneRow(self, root, v, d):
        """
        :type root: TreeNode
        :type v: int
        :type d: int
        :rtype: TreeNode
        """
        if d == 1:
            newRoot = TreeNode(v)
            newRoot.left = root
            return newRoot

        from collections import deque
        tree_queue = deque()
        tree_queue.append((root,1))
        while len(tree_queue) != 0:
            cur = tree_queue.popleft()
            if cur[1] == d-1:
                left = TreeNode(v)
                left.left = cur[0].left
                right = TreeNode(v)
                right.right = cur[0].right
                cur[0].left = left
                cur[0].right = right
            else:
                if cur[0].left:
                    tree_queue.append((cur[0].left,cur[1]+1))
                if cur[0].right:
                    tree_queue.append((cur[0].right,cur[1]+1))

        return root

