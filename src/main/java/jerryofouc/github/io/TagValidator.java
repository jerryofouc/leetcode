package jerryofouc.github.io;

import java.util.Stack;

/**
 * Created by xiaojiez on 6/5/17.
 */
public class TagValidator {
    public static boolean isValid(String code) {
        Stack<String> stack = new Stack<>();
        String a = code;
        if(code == null || code.isEmpty()||code.charAt(0)!='<'||code.charAt(1)>'Z'||code.charAt(1)<'A'){
            return false;
        }
        if(code.charAt(code.length()-1)!='>'||code.charAt(code.length()-2)>'Z'||code.charAt(code.length()-2)<'A'){
            return false;
        }
        while (true){
            int s = a.indexOf("<![CDATA[");
            if(s<0){
                break;
            }
            int e = a.indexOf("]]>",s);
            if(e>0){
                a = a.substring(0,s)+a.substring(e+3);
            }else {
                return false;
            }
        }
        char[] array = a.toCharArray();

        int state = 0;
        int last = -1;
        for(int i=0;i<array.length;i++){
            if(state == 0){
                if(array[i] == '<'){
                    state = 1;
                    last = i;
                }
            }else if(state == 1){
                if(array[i] == '/'){
                    state = 2;
                }else if(array[i] == '>'){
                    if(i - last<=1){
                        return false;
                    }else {
                        String tagName = a.substring(last+1,i);
                        stack.push(tagName);
                        if(tagName.length()>9){
                            return false;
                        }
                        state = 0;
                    }
                }else if(array[i]<'A' || array[i]>'Z'){
                    return false;
                }
            }else if(state == 2){
                if(array[i] == '>'){
                    if(i - last<=2){
                        return false;
                    }
                    if(stack.isEmpty()){
                        return false;
                    }
                    String temp = stack.pop();
                    if(stack.isEmpty()&&i!=a.length()-1){
                        return false;
                    }
                    if(!a.substring(last+2,i).equals(temp)){
                        return false;
                    }
                    state = 0;
                }else if(array[i]<'A' || array[i]>'Z'){
                    return false;
                }
            }
        }
        return stack.isEmpty()&&state==0;
    }

    public static void main(String[] args) {
        System.out.println(isValid("<AAAAAAAAAA></AAAAAAAAAA>"));
    }


}
