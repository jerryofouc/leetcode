package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 4/6/14
 * Time: 20:49
 * To change this template use File | Settings | File Templates.
 */
public class Utils {
    public static TreeNode deserializeTree(char[] list){
        return deserializeTree(0,list);
    }

    private static TreeNode deserializeTree(int cur, char[] list) {
        if(cur < list.length){
            if(list[cur] != '#'){
                TreeNode treeNode = new TreeNode(Integer.parseInt(list[cur]+""));
                treeNode.left = deserializeTree(cur*2+1, list);
                treeNode.right = deserializeTree(cur*2+2, list);
                return treeNode;
            }else{
                return null;
            }
        }
        return null;
    }

    public static ListNode getListNode(int[] a){
        ListNode preHeader = new ListNode(-1);
        ListNode cur = preHeader;
        for(int i=0;i<a.length;i++){
            cur.next = new ListNode(a[i]);
            cur = cur.next;
        }
        return preHeader.next;
    }
}
