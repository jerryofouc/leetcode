package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/26/17.
 */
public class RemoveBoxes {
//    public int removeBoxes(int[] boxes) {
//        if(boxes == null || boxes.length == 0){
//            return 0;
//        }
//        if(isAllSame(boxes)){
//            return boxes.length*boxes.length;
//        }
//        int result = 0;
//        Map<Integer,Integer> map = new HashMap<>();
//        for(int i=0;i<boxes.length;){
//            int j = i+1;
//            while (j<boxes.length && boxes[i] == boxes[j]){
//                j++;
//            }
//            map.put(boxes[i],map.getOrDefault(boxes[i],0));
//            i=j;
//        }
//        int size = 0;
//        for(int i=0;i<boxes.length;){
//            if(map.get(boxes[i]) != 1){
//                boxes[size++] = boxes[i];
//                i++;
//            }else {
//                int j = i+1;
//                while (j<boxes.length && boxes[i] == boxes[j]){
//                    j++;
//                }
//                result += (j-i)*(j-i);
//                i=j;
//            }
//        }
//        if(size == 0){
//            return result;
//        }
//
//        int[] newBox = new int[size];
//        System.arraycopy(boxes,0,newBox,0,size);
//        boxes = newBox;
//
//        int start = 0;
//        int end = start+1;
//        while (boxes[start] == boxes[end]){
//            end++;
//        }
//
//        int nextStart = -1;
//        for(int i=end;i<boxes.length;i++){
//            if(boxes[i] == boxes[start]){
//                nextStart = i;
//                break;
//            }
//        }
//
//
//
//
//
//
//
//    }
//
//    private boolean isAllSame(int[] boxes) {
//        int first = boxes[0];
//        for(int i=1;i<boxes.length;i++){
//            if(first != boxes[i]){
//                return false;
//            }
//        }
//        return true;
//    }
}
