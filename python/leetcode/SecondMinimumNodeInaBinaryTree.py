# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def findSecondMinimumValue(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root or not root.left:
            return -1

        if root.left.val < root.right.val:
            left_val = self.findSecondMinimumValue(root.left)
            if left_val == -1:
                return root.right.val
            else:
                return min(left_val,root.right.val)
        if root.left.val > root.right.val:
            right_val = self.findSecondMinimumValue(root.right)
            if right_val == -1:
                return root.left.val
            else:
                return min(right_val,root.left.val)
        else:
            left_val = self.findSecondMinimumValue(root.left)
            right_val = self.findSecondMinimumValue(root.right)
            if left_val == -1:
                return right_val
            if right_val == -1:
                return left_val
            return min(left_val,right_val)

