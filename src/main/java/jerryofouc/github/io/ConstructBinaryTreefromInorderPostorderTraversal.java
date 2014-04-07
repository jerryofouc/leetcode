package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 4/1/14
 * Time: 23:12
 * To change this template use File | Settings | File Templates.
 */
public class ConstructBinaryTreefromInorderPostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }

        private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
            if (inStart <= inEnd) {
                int root = postorder[postEnd];
                int inRootIndex = -1;
                for (int i = inStart; i <= inEnd; i++) {
                    if (inorder[i] == root) {
                        inRootIndex = i;
                        break;
                    }
                }
                TreeNode treeNode = new TreeNode(root);
                treeNode.left = buildTree(inorder, inStart, inRootIndex - 1, postorder, postStart, postStart + inRootIndex - 1 - inStart);
                treeNode.right = buildTree(inorder, inRootIndex + 1, inEnd, postorder, postStart + inRootIndex - 1 - inStart + 1, postEnd - 1);
                return treeNode;
            } else {
                return null;
            }
        }
}
