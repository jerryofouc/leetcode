package jerryofouc.github.io;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaojiez on 3/18/17.
 */
public class CountTheRepetitions {
    public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int s1_count = 0;
        int s2_count = 0;
        int j = 0;
        boolean isFound = false;
        Map<Integer,Integer> firstIndexMapS2 = new HashMap<>();
        Map<Integer,Integer> firstIndexMapS1 = new HashMap<>();

        int s1_num = 0;
        int s2_num = 0;
        int pre  = 0;
        int end = -1;
        int minus = 0;
        while (!isFound){
            boolean shouldReturn = true;
            for(int i=0;i<s1.length();i++){
                if(s1.charAt(i) == s2.charAt(j)){
                    shouldReturn = false;


                    if(j == 0){
                        Integer pre_s2_count = firstIndexMapS2.get(i);
                        if(pre_s2_count == null){
                            firstIndexMapS2.put(i,s2_count);
                            firstIndexMapS1.put(i,s1_count);

                        }else {
                            s1_num = s1_count - firstIndexMapS1.get(i);
                            s2_num = s2_count - pre_s2_count;
                            isFound = true;
                            if(end == s1_count){
                                minus = -1;
                            }
                        }
                    }
                    j++;
                    if(j==s2.length()){
                        s2_count++;
                        j = 0;
                        if(s1_count==0){
                            pre++;
                        }
                        end=s1_count;

                    }
                }
            }
            if(shouldReturn){
                return 0;
            }
            s1_count++;

            if(isFound){
                break;
            }
        }




        return ((n1+minus)/s1_num*(s2_num)+pre)/n2;

    }

    public static void main(String[] args) {
//       System.out.println(getMaxRepetitions("acb",4,"ab",2));
//        System.out.println(
//                getMaxRepetitions(
//                        "lovenicoloveliveniconiconiconiniconjcoaaajo",201641,"lovenanjo",401));

        case1();
        case2();
        case3();
        case4();
        case5();
        case6();
        case7();
    }

    static void case1(){
        System.out.println(getMaxRepetitions("acb",4,"ab",2));
    }

    static void case2(){
        System.out.println(getMaxRepetitions("nlhqgllunmelayl",10000,"lnl",10));
    }

    static void case3(){
        System.out.println(
                getMaxRepetitions(
                        "lovenicoloveliveniconiconiconiniconjcoaaajo",201641,"lovenanjo",401));
    }

    static void case4(){
        System.out.println(getMaxRepetitions("musicforever",10,"lovelive",100000));
    }

    static void case5(){
        System.out.println(getMaxRepetitions("phqghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvsrtkjprepggxrpnrvystmwcysyycqpevikeffmznimkkasvwsrenzkycxf",
                100000,"xtlsgypsfadpooefxzbcoejuvpvaboygpoeylfpbnpljvrvipyamyehwqnqrqpmxujjloovaowuxwhmsncbxcoksfzkvatxdknly",1));
    }
    static void case6(){
        System.out.println(getMaxRepetitions("a",1000000,
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",1000));
    }

    static void case7(){
        System.out.println(getMaxRepetitions("phqghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvsrtkjprepggxrpnrvystmwcysyycqpevikeffmznimkkasvwsrenzkycxf",100,
                "xtlsgypsfa",1));
    }
}
