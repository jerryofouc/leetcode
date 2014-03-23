package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 3/23/14
 * Time: 21:48
 * To change this template use File | Settings | File Templates.
 */
public class ConstructBinaryTreefromPreorderInorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder,0,preorder.length-1,0,inorder.length-1);
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder, int pStart, int pEnd, int iStart, int iEnd) {
        if(pStart <= pEnd&&iStart<=iEnd&&pEnd<preorder.length&&iEnd<inorder.length){
            TreeNode root = new TreeNode(preorder[pStart]);
            int midIndex = findIndex(inorder,preorder[pStart],iStart,iEnd);
            root.left = buildTree(preorder,inorder,pStart+1,pStart+midIndex-iStart,iStart,midIndex-1);
            root.right = buildTree(preorder,inorder,pStart+midIndex-iStart+1,pEnd,midIndex+1,iEnd);
            return root;
        }else{
            return null;
        }
    }

    private static int findIndex(int[] array,int val,int start,int end){
        for(int i=start;i<=end;i++){
            if(array[i] == val){
                return i;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        int [] pre = {1,2};
        int [] in = {1,2};
        buildTree(pre,in);
    }
}
