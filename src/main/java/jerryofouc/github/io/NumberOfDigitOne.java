package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/26/17.
 */
public class NumberOfDigitOne {
    public static int countDigitOne(int n) {
        long x = n;
        int sum = 0;
        long k = 10;
        while (x/k != 0){
            long a = x/k;

            if(x%k>=2*k/10){
                a = a+1;
            }else if(x%k>=k/10&&x%k<2*k/10){
                sum += x%(k/10)+1;
            }
            sum += a*k/10;
            k *= 10;
        }

        if(x%k>=2*k/10){
            sum += k/10;
        }else if(x%k>=k/10&&x%k<2*k/10){
            sum += x%(k/10)+1;
        }


        return sum;
    }

    public static int v1(int n){
        int total = 0;
        for(int i=0;i<=n;i++){
            int t = i;
            while (true){
                if(t%10==1){
                    total++;
                }
                t = t/10;
                if(t ==0){
                    break;
                }
            }
        }
        return total;
    }



    public static void main(String[] args) {
//        for(int i=0;i<100000;i++){
//            int a = countDigitOne(i);
//            int b = v1(i);
//            if(a != b){
//                System.out.println(" a="+a+" b="+b);
//            }
//        }
        System.out.println(countDigitOne(1410065408));

    }
}
