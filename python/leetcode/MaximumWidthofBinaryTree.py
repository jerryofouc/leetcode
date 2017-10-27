from get_tree import build_tree


class Solution(object):
    def widthOfBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        map = {}

        def tranverse(root,value,level):
            if root:
                array =  map.get(level,[])
                array.append(value)
                map[level] = array
                tranverse(root.left,value*2+1,level+1)
                tranverse(root.right,value*2+2,level+1)
            else:
                return

        tranverse(root,0,0)
        max_width = 0
        for key, value in map.iteritems():
            max_width = max(max_width,max(value)-min(value)+1)

        return max_width


if __name__ == '__main__':
    s = Solution()
    root = build_tree([1,3,"null",5,3])
    print s.widthOfBinaryTree(root)




