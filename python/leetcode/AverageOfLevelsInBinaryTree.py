# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None



class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def averageOfLevels(self, root):
        """
        :type root: TreeNode
        :rtype: List[float]
        """
        from Queue import Queue
        queue = Queue()
        result_map = {}
        queue.put((root,0))
        result_map[0] = [root.val]
        while not queue.empty():
            node_tuple = queue.get()
            if node_tuple[0].left:
                s = result_map.get(node_tuple[1]+1,[])
                s.append(node_tuple[0].left.val)
                result_map[node_tuple[1]+1] = s
                queue.put((node_tuple[0].left,node_tuple[1]+1))
            if node_tuple[0].right:
                s = result_map.get(node_tuple[1]+1,[])
                s.append(node_tuple[0].right.val)
                result_map[node_tuple[1]+1] = s
                queue.put((node_tuple[0].right,node_tuple[1]+1))
        result = []
        for i in xrange(len(result_map)):
            result.append(0)
        for key, value in result_map.iteritems():
            result[key] = float(sum(value))/len(value)
        return result



if __name__ == '__main__':
    s = Solution()
    root = TreeNode(3)
    root_left = TreeNode(9)
    root_right = TreeNode(20)
    root_right_left = TreeNode(15)
    root_right_right = TreeNode(7)
    root_right.left = root_right_left
    root_right.right = root_right_right
    root.left = root_left
    root.right = root_right
    print s.averageOfLevels(root)


