from get_tree import TreeNode


class Solution(object):
    def constructMaximumBinaryTree(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        def get_max(start,end):
            if start==end:
                return start
            max_cur = start
            for i in xrange(start+1,end+1):
                if nums[max_cur] < nums[i]:
                    max_cur = i
            return max_cur

        def construct_tree(start,end):
            m = get_max(start,end)
            root = TreeNode(nums[m])
            if m>start:
                root.left = construct_tree(start,m-1)
            if m < end:
                root.right = construct_tree(m+1,end)
            return root

        return construct_tree(0,len(nums)-1)


if __name__ == '__main__':
    s = Solution()
    root = s.constructMaximumBinaryTree([3,2,1,6,0,5])
    print root
