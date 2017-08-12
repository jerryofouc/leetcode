
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def build_tree(l):
    def get_node(root,index):
        if index*2+1 < len(l):
            if l[index*2+1] != "null":
                root.left = TreeNode(int(l[index*2+1]))
                get_node(root.left,index*2+1)

        if index*2+1 < len(l):
            if l[index*2+2] != "null":
                root.right = TreeNode(int(l[index*2+2]))
                get_node(root.right,index*2+2)
    root = TreeNode(int(l[0]))
    get_node(root,0)
    return root


if __name__ == '__main__':
    root = build_tree([5,3,6,2,4,"null",7])
    print root
    