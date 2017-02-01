package jerryofouc.github.io;

/**
 * Created by xiaojiez on 2/1/17.
 */
public class IntegerToEnglishWords {
    public static String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }
        String aa[] = new String[]{""," Thousand"," Million"," Billion"};
        String bb[] = new String[]{"One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        String cc[] = new String[]{"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String dd[] = new String[]{"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};





        String result = "";
        for(int i=0;i<4;i++){
            String curResult = "";
            int k = num%1000;
            if(k != 0){
                if(k/100 != 0){
                    curResult += bb[k/100-1] +" Hundred";
                }
                k = k%100;
                if(k>0){
                    if(k<10){
                        curResult += " " + bb[k-1];
                    }else if(k<20){
                        curResult += " " + cc[k-10];
                    }else {
                        curResult +=" " + dd[k/10-2];
                        if(k%10 != 0){
                            curResult += " " + bb[k%10-1];
                        }
                    }
                }



                result = curResult + aa[i] + " " + result;

                result = result.trim();
            }



            num = num/1000;
            if(num == 0){
                break;
            }
        }

        return result.trim();
    }

    public static void main(String[] args) {
        System.out.println(numberToWords(1001));
    }
}
