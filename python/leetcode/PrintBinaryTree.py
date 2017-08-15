# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from get_tree import build_tree


class Solution(object):
    def printTree(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[str]]
        """
        def traverse(start_colum,end_colum,row,root):
            if not root:
                return
            else:
                mid = (start_colum+end_colum)/2
                result[row][mid] = str(root.val)
                traverse(start_colum,mid-1,row+1,root.left)
                traverse(mid+1,end_colum,row+1,root.right)
        max_depth = self.__find_max_depth(root)
        rows = max_depth
        colums = 2**rows-1
        result = [["" for i in xrange(colums)] for j in xrange(rows)]
        traverse(0,colums,0,root)
        return result



    def __find_max_depth(self,root):
        if not root:
            return 0
        return max(self.__find_max_depth(root.left),self.__find_max_depth(root.right))+1


if __name__ == '__main__':
    s = Solution()
    root = build_tree([1,2,"null"])
    result = s.printTree(root)
    print result