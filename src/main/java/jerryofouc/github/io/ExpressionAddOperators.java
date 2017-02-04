package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaojiez on 2/1/17.
 */
public class ExpressionAddOperators {
    public static List<String> addOperators(String num, int target) {
        if(num ==null ||num.length() == 0 ){
            return new ArrayList<>();
        }

        try {
            long a = Long.parseLong(num);
            if(a<(long)target){
                return new ArrayList<>();
            }
            if(num.charAt(0) !='0' && a == target && a != 0){
                List<String> r = new ArrayList<>();
                r.add(num);
                return r;
            }
            if(num.charAt(0) !='0' && a<=Math.abs((long)target)&& a != 0){
                return new ArrayList<>();
            }
        }catch (Exception e){

        }

        char[] numArray = num.toCharArray();
        Map<String,Integer>[][] multiplyMap = new Map[num.length()][num.length()];
        for(int i=0;i<multiplyMap.length;i++){
            Map<String,Integer> map = new HashMap<>();
            map.put(Character.toString(numArray[i]),numArray[i]-'0');
            multiplyMap[i][i] = map;
        }
        for(int len=1;len<multiplyMap.length;len++){
            for(int i=0;i<multiplyMap.length-len;i++){
                Map<String,Integer> resultMap = new HashMap<>();

                //*
                for(Map.Entry<String,Integer> entry : multiplyMap[i][i+len-1].entrySet()){
                    resultMap.put(entry.getKey()+"*"+numArray[i+len],entry.getValue()*(numArray[i+len]-'0'));
                }

                for(int j=i+len-1;j>=i;j--){
                    if(numArray[j] != '0'){
                        int cur;
                        try{
                            cur = Integer.parseInt(num.substring(j,i+len+1));
                        }catch (NumberFormatException e){
                            continue;
                        }

                        if(j==i){
                            resultMap.put(Integer.toString(cur),cur);
                        }else {
                            for(Map.Entry<String,Integer> entry : multiplyMap[i][j-1].entrySet()){
                                resultMap.put(entry.getKey()+"*"+cur,entry.getValue()*cur);
                            }
                        }
                    }
                }
                multiplyMap[i][i+len] = resultMap;
            }
        }

        Map<String,Integer>[] resultMem = new Map[num.length()];
        Map<String,Integer> first = new HashMap<>();
        first.put(numArray[0]+"",numArray[0]-'0');
        resultMem[0] = first;

        for(int i=1;i<numArray.length;i++){
            Map<String,Integer> map = new HashMap<>();
            for(int j=i;j>0;j--){
                Map<String,Integer> firstHalf = resultMem[j-1];
                Map<String,Integer> sencondHalf = multiplyMap[j][i];
                if(!sencondHalf.isEmpty()){
                    for(Map.Entry<String,Integer> e1 : firstHalf.entrySet()){
                        for(Map.Entry<String,Integer> e2 : sencondHalf.entrySet()){
                            map.put(e1.getKey()+"-"+e2.getKey(),e1.getValue()-e2.getValue());
                            map.put(e1.getKey()+"+"+e2.getKey(),e1.getValue()+e2.getValue());
                        }
                    }
                }
            }
            map.putAll(multiplyMap[0][i]);
            resultMem[i] = map;
        }

        List<String> resultList = new ArrayList<>();
        for(Map.Entry<String,Integer> e1 : resultMem[resultMem.length-1].entrySet()){
            if(e1.getValue() == target){
                resultList.add(e1.getKey());
            }
        }

        return resultList;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(addOperators("2147483648",-2147483648));
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
