package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/12/17.
 */
public class PathSumIII {
    public  static int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        int result = 0;

        if(sum == root.val){
            result++;
        }
        return result+pathSum(root.left,sum-root.val,true) + pathSum(root.right,sum-root.val,true)
                +pathSum(root.left,sum,false)+pathSum(root.right,sum,false);
    }

    private static int pathSum(TreeNode root, int sum, boolean isInclude) {
        if(root == null){
            return 0;
        }
        int result = 0;
        if(root.val == sum){
            result++;
        }
        if(isInclude){
            return result+pathSum(root.left,sum-root.val,true) + pathSum(root.right,sum-root.val,true);
        }else {
            return result+pathSum(root.left,sum-root.val,true)+pathSum(root.right,sum-root.val,true)+
                    pathSum(root.left,sum,false)+pathSum(root.right,sum,false);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5= new TreeNode(5);
        treeNode1.right = treeNode2;
        treeNode2.right = treeNode3;
        treeNode3.right = treeNode4;
        treeNode4.right = treeNode5;
        System.out.println(pathSum(treeNode1,3));

    }
}
