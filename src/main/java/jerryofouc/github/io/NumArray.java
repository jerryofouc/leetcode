package jerryofouc.github.io;

/**
 * Created by xiaojiez on 2/9/17.
 */
public class NumArray {
    SegmentTree root;
    private static class SegmentTree{
        int sum;
        int start;
        int end;
        SegmentTree left;
        SegmentTree right;
    }
    int[] nums;

    public NumArray(int[] nums) {
        if( nums==null ||nums.length == 0 ){
            return;
        }
        root = buildTree(nums,0,nums.length-1);
        this.nums = nums;
    }

    private SegmentTree buildTree(int[] nums, int start, int end) {
        SegmentTree segmentTree = new SegmentTree();
        segmentTree.start = start;
        segmentTree.end = end;
        int sum = 0;
        for(int i=start;i<=end;i++){
            sum+=nums[i];
        }
        segmentTree.sum = sum;
        if(start == end){
            return segmentTree;
        }
        int mid = start + (end-start)/2;
        segmentTree.left = buildTree(nums,start,mid);
        segmentTree.right = buildTree(nums,mid+1,end);
        return segmentTree;
    }

    public void update(int i, int val) {
        update(root,i,val-this.nums[i]);
        nums[i] = val;
    }

    private void update(SegmentTree root, int i, int val) {
        root.sum += val;
        int mid = root.start + (root.end-root.start)/2;
        if(i<=mid&&root.left != null){
            update(root.left,i,val);
        }
        if(i>mid && root.right!=null){
            update(root.right,i,val);
        }
    }

    public int sumRange(int i, int j) {
        return sumRange(root,i,j);
    }

    private int sumRange(SegmentTree root, int i, int j) {
        if(i == root.start && j == root.end){
            return root.sum;
        }
        int mid = root.start + (root.end-root.start)/2;
        if(j<=mid){
            return sumRange(root.left,i,j);
        }else if(i>mid){
            return sumRange(root.right,i,j);
        }else {
            return sumRange(root.left,i,mid)+sumRange(root.right,mid+1,j);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5,7,9};
        NumArray numArray = new NumArray(nums);
        numArray.update(2,1);
        System.out.println(numArray.sumRange(1,3));

    }
}
