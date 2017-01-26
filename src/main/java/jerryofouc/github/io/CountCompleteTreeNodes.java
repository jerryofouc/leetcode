package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/25/17.
 */
public class CountCompleteTreeNodes {
    public static int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        TreeNode cur = root;
        int ll = 0;
        while (cur.left !=null){
            cur = cur.left;
            ll++;
        }

        cur = root;
        int rl = 0;
        while (cur.right !=null){
            cur = cur.right;
            rl++;
        }

        if(ll == rl){
            return (1<<(rl+1))-1;
        }

        int l = 0,r = (1<<(ll))-1;

        int x = l;
        while (l<=r){
            int m = (l+r)/2;
            cur = root;
            int k = (1<<(ll-1));
            int height = 0;
            int a = k&m;
            if(a ==0){
                cur = cur.left;
            }else {
                cur =cur.right;
            }
            k = k>>1;
            while (cur != null){
                height++;
                a = k&m;
                if(a ==0){
                    cur = cur.left;
                }else {
                    cur =cur.right;
                }
                k = k>>1;
            }
            if(ll==height){
                l = m+1;
                x = m;
            }else {
                r = m-1;
                x = m-1;
            }
        }
        return (1<<(ll))-1+x+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode f = new TreeNode(4);
        TreeNode d = new TreeNode(4);
        TreeNode q = new TreeNode(4);
        TreeNode g = new TreeNode(4);
        TreeNode v = new TreeNode(4);
        TreeNode vv = new TreeNode(4);
        TreeNode vvv = new TreeNode(4);
        root.left = left;
        root.right = right;
        root.left.left = f;
        root.left.right = d;
        root.right.left = q;
        root.right.right = g;
        root.left.left.left = v;
       // root.left.left.right = vv;
       // root.left.right.left = vvv;


        System.out.println(countNodes(root));
    }
}
