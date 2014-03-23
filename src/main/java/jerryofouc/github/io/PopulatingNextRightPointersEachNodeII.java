package jerryofouc.github.io;

import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 3/18/14
 * Time: 22:21
 * To change this template use File | Settings | File Templates.
 */
public class PopulatingNextRightPointersEachNodeII {

    public static class Pair<K, V> {

        private  K element0;
        private  V element1;

        public static <K, V> Pair<K, V> createPair(K element0, V element1) {
            return new Pair<K, V>(element0, element1);
        }

        public Pair(K element0, V element1) {
            this.element0 = element0;
            this.element1 = element1;
        }

        public K getElement0() {
            return element0;
        }

        public V getElement1() {
            return element1;
        }

        public void setElement0(K element0){
            this.element0 = element0;
        }


        public void setElement1(V element1) {
            this.element1 = element1;
        }
    }
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public static void connect(TreeLinkNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return ;
        }
        TreeLinkNode left = root.left;
        TreeLinkNode right = root.right;
        if(left != null && right != null){
            left.next = right;
            TreeLinkNode nextLeft;
            if(left.right != null){
                nextLeft = left.right;
            }else{
                nextLeft = left.left;
            }

            TreeLinkNode nextRight;
            if(right.left != null){
                nextRight = right.left;
            }else{
                nextRight = right.right;
            }

            while(nextLeft!=null && nextRight!=null){
                nextLeft.next = nextRight;
                if(nextLeft.right != null){
                    nextLeft = nextLeft.right;
                }else{
                    nextLeft = nextLeft.left;
                }
                if(nextRight.left != null){
                    nextRight = nextRight.left;
                }else{
                    nextRight = nextRight.right;
                }
            }
        }

        if(root.left!=null){
            connect(root.left);
        }

        if(root.right != null){
            connect(root.right);
        }
    }

    public static void main(String args[]){
        int[] input = {1,2,3,4,5,'#',6,7,'#','#','#','#',8};
        Pair<int[],Integer> pair = Pair.createPair(input,0);
        TreeLinkNode treeLinkNode = deserializeTree(pair);
        connect(treeLinkNode);
        System.out.println("xx");
    }

    private static TreeLinkNode deserializeTree(Pair<int[], Integer> pair) {
        int[] array = pair.getElement0();
        int curIndex = pair.getElement1();
        if(curIndex < array.length){
            if(array[curIndex] != '#'){
                TreeLinkNode treeLinkNode = new TreeLinkNode(array[curIndex]);
                pair.setElement1(curIndex+1);
                treeLinkNode.left = deserializeTree(pair);
                treeLinkNode.right = deserializeTree(pair);
                return treeLinkNode;
            }else{
                pair.setElement1(curIndex+1);
                return null;
            }
        }else{
            return null;
        }
    }

    public static void  connect2(TreeLinkNode root) {
        if (root == null) return; // simple
        if (root.left == null && root.right == null) return; // simple
        TreeLinkNode last = root.right; if (last == null) last = root.left;
        // last means the rightest of the existing sons.
        // first means the leftest of the sons of right brothers of the root.
        TreeLinkNode first = root.next;
        while (true) {
            if (first == null) break;
            //as far as somne of our right brothers has children we shoudl link our last with it.
            if (first.left != null) {
                last.next = first.left;
                break;
            }
            if (first.right != null) {
                last.next = first.right;
                break;
            }
            first = first.next;
        }
        // linking our childrens if both exists
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }

        connect2(root.right);
        connect2(root.left);
    }



}
