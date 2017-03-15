package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/15/17.
 */
public class DeleteNodeinaBST {
    public static TreeNode deleteNode(TreeNode root, int key) {
        TreeNode head = new TreeNode(Integer.MAX_VALUE);
        head.left = root;
        TreeNode parent = head;
        TreeNode cur = root;
        while (cur != null&&cur.val != key){
            parent = cur;
            if(key>cur.val){
                cur = cur.right;
            }else {
                cur = cur.left;
            }
        }

        if(cur != null){
            delete(parent,cur);
        }
        return head.left;
    }

    private static void delete(TreeNode parent, TreeNode cur) {
        if(cur.left == null&&cur.right == null){
            if(parent.left == cur){
                parent.left = null;
            }else {
                parent.right = null;
            }
        }else {
            if(cur.left == null){
                if(parent.left == cur){
                    parent.left = cur.right;
                }else {
                    parent.right = cur.right;
                }
            }else if(cur.right == null){
                if(parent.left == cur){
                    parent.left = cur.left;
                }else {
                    parent.right = cur.left;
                }
            }else{
                if(cur.right.left == null){
                    cur.right.left = cur.left;
                    if(parent.left == cur){
                        parent.left = cur.right;
                    }else {
                        parent.right = cur.right;
                    }

                }else {
                    int min = findMin(cur.right);
                    cur.val = min;
                }
            }
        }
    }

    private static int findMin(TreeNode right) {
        TreeNode parent = right;
        TreeNode left = right.left;
        while (left.left != null){
            parent = left;
            left = left.left;
        }
        parent.left = left.right;
        return left.val;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        deleteNode(treeNode,1);

    }

}
