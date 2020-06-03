package arithmetic;
/**
 * n+1个元素存储在长度为n的数组中，且数组元素 1 <= value <=n,
 * 需要找出一个重复的value
 * Created by 10718 on 2019/10/14.
 */
public class FindRepeatNumFromArr {
    static int[] arr = {2,3,5,4,3,2,6,7};
    private static boolean findOneRepeatValue(int startIndex ,int endIndex){
        int  num = 0;
        for(int i =0;i<arr.length;i++){
            if(num > (endIndex-startIndex+1)){ //肯定有重复值
                return true;
            }
            if(startIndex <= arr[i] && arr[i] <= endIndex){
                num ++;
            }
        }
        if(num > (endIndex-startIndex+1)){ //肯定有重复值
            return true;
        }
        return false;
    }

    private static void find(int startIndex ,int endIndex){
        int middleValue = (startIndex+endIndex)/2;
        boolean isPrefixRepeat = findOneRepeatValue(startIndex,middleValue);
        if(isPrefixRepeat && startIndex==middleValue){
            System.out.println("the one repeated value is:"+startIndex);
        }

        boolean isSuffixRepeat = findOneRepeatValue(middleValue+1,endIndex);
        if(isSuffixRepeat && middleValue+1 == endIndex){
            System.out.println("the one repeated value is:"+endIndex);
        }

        if(isPrefixRepeat && startIndex<middleValue) {
            find(startIndex, middleValue);
        }
        if(isSuffixRepeat && middleValue+1 < endIndex) {
            find(middleValue + 1, endIndex);
        }


    }

    public static void main(String[] args) {
        int len = arr.length;
        find(1,len);
    }
}
