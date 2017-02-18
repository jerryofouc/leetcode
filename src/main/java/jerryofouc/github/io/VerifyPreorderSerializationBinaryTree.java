package jerryofouc.github.io;

import java.util.Stack;

/**
 * Created by xiaojiez on 2/18/17.
 */
public class VerifyPreorderSerializationBinaryTree {
    public static boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length() == 0){
            return true;
        }
        String[] preOrderStr = preorder.split(",");

        Stack<String> stack = new Stack<>();
        int i=0;
        while (i<preOrderStr.length&&!preOrderStr[i].equals("#") ){
            stack.push(preOrderStr[i++]);
        }
        i++;


        while (!stack.isEmpty()){
            stack.pop();
            while (i<preOrderStr.length&&!preOrderStr[i].equals("#") ){
                stack.push(preOrderStr[i++]);
            }
            i++;
        }

        return i==preOrderStr.length;
    }

    public static void main(String[] args) {
        System.out.println(isValidSerialization("9,#,#,1"));
    }


}
