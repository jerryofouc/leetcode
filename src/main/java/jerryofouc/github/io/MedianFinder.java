package jerryofouc.github.io;

/**
 * Created by xiaojiez on 2/4/17.
 */
public class MedianFinder {
    private int[] maxHeap = new int[10000];
    private int maxHeapSize = 0;
    private int[] minHeap = new int[10000];
    private int minHeapSize = 0;

    public MedianFinder() {
    }

    public void addNum(int num) {
        if(maxHeapSize == 0 && minHeapSize == 0){
            maxHeap[0] = num;
            maxHeapSize++;
            return;
        }
        if(maxHeapSize == 1 && minHeapSize == 0){
            if(num<maxHeap[0]){
                minHeap[minHeapSize++] = maxHeap[0];
                maxHeap[0] = num;
            }else {
                minHeap[minHeapSize++] = num;
            }
            return;
        }

        if(num<maxHeap[0]){
            maxHeap[maxHeapSize] = num;
            heapifyMax();
        }else {
            minHeap[minHeapSize] =num;
            heapifyMin();
        }

        if(maxHeapSize-minHeapSize>1){
            minHeap[minHeapSize] = maxHeap[0];
            heapifyMin();
            maxHeap[0] = maxHeap[maxHeapSize-1];
            maxHeapSize--;
            buildDownMax();
        }

        if(minHeapSize-maxHeapSize>1){
            maxHeap[maxHeapSize] = minHeap[0];
            heapifyMax();
            minHeap[0] = minHeap[minHeapSize-1];
            minHeapSize --;
            buildDownMin();
        }






    }

    private void buildDownMin() {
        int cur =0;
        while (cur*2+1<minHeapSize){
            int min = cur;
            if(minHeap[min]>minHeap[cur*2+1]){
                min = cur*2+1;
            }
            if(cur*2+2<minHeapSize&&minHeap[min]>minHeap[cur*2+2]){
                min = cur*2+2;
            }
            int temp = minHeap[cur];
            minHeap[cur] = minHeap[min];
            minHeap[min] = temp;
            if(cur == min){
                break;
            }
            cur = min;
        }
    }

    private void buildDownMax() {
        int cur =0;
        while (cur*2+1<maxHeapSize){
            int max = cur;
            if(maxHeap[max]<maxHeap[cur*2+1]){
                max = cur*2+1;
            }
            if(cur*2+2<maxHeapSize&&maxHeap[max]<maxHeap[cur*2+2]){
                max = cur*2+2;
            }
            int temp = maxHeap[cur];
            maxHeap[cur] = maxHeap[max];
            maxHeap[max] = temp;
            if(cur == max){
                break;
            }
            cur = max;
        }
    }

    private void heapifyMax() {
        int cur = maxHeapSize;
        while ((cur-1)/2>=0&&maxHeap[cur]>maxHeap[(cur-1)/2]){
            int temp = maxHeap[(cur-1)/2];
            maxHeap[(cur-1)/2] = maxHeap[cur];
            maxHeap[cur] = temp;
            cur = (cur-1)/2;
        }
        maxHeapSize++;
    }


    private void heapifyMin(){
        int cur = minHeapSize;
        while ((cur-1)/2>=0&&minHeap[cur]<minHeap[(cur-1)/2]){
            int temp = minHeap[(cur-1)/2];
            minHeap[(cur-1)/2] =  minHeap[cur];
            minHeap[cur] = temp;
            cur = (cur-1)/2;
        }
        minHeapSize++;
    }

    public double findMedian() {
        if(minHeapSize == maxHeapSize){
            return (maxHeap[0] + minHeap[0])/2.0;
        }else if(maxHeapSize>minHeapSize){
            return maxHeap[0];
        }else {
            return minHeap[0];
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(5);
        medianFinder.addNum(6);
        medianFinder.addNum(7);
        medianFinder.addNum(8);
        medianFinder.addNum(9);
        medianFinder.addNum(10);
        System.out.println(medianFinder.findMedian());





    }

}
