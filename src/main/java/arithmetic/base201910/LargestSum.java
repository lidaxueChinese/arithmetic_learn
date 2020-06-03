package arithmetic.base201910;
/**连续数组的最大和
 * Created by 10718 on 2019/10/26.
 * 注意点：
 * 1. 如果前面连续累计计数<0 ,则可以抛弃之前数据
 * 2. largestValue：保存可能拿到的最大值，secondeLarge：只要连续累计>0就一直往后累加直到小于0
 */
public class LargestSum {

    private static Integer getLargestSum(int[] arr){
        if(arr == null){
            return null;
        }

        int largestValue = 0;
        int largestIndex = -1;

        Integer secondeLarge =0;
        Integer secondeIndex = -1;


        for(int i = 0 ;i <arr.length;i++){
            if(arr[i] > 0 && i-largestIndex ==1){
                largestValue = arr[i];
                largestIndex = i;
            }

            if(secondeLarge + arr[i] > 0){
               secondeLarge+= arr[i];
            }else{  //如果小于0 ，则抛弃之前的计数，secondeLarge=0表示抛弃之前的计数
                secondeLarge = 0;
            }
            secondeIndex ++;

            if(secondeLarge > largestValue){
                largestValue = secondeLarge;
                largestIndex = secondeIndex;
            }

        }

        return  largestValue;
    }

    public static void main(String[] args) {
        int[] arr = {1,-2,3,10,-4,7,2,-5};
        Integer largeValue = getLargestSum(arr);
        System.out.println("the largest value is:"+largeValue);
    }
}
