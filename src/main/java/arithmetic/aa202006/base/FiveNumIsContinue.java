package arithmetic.aa202006.base;
/**
 * Created by lidaxue on 2020/7/2.
 * 判断某个连续的正数（1到9之间）是否是连续的，0可以表示任意的数
 * 剑指offer 61
 */
public class FiveNumIsContinue {

    public static void main(String[] args) {
        int[] arr = {6,4,3,0,0};

        //TODO　1.sort
        sort(arr);

        //TODO check
        int numZero = 0;
        int margin = 0;
        boolean isHaveFirstNum = false;
        for(int index = 0;index<arr.length;index++){
            if(arr[index] == 0){
                numZero ++;
            }else if(!isHaveFirstNum){
                isHaveFirstNum = true;
            }else{
                if(arr[index] == arr[index-1]){
                    margin = Integer.MAX_VALUE;
                    break;
                }else if(arr[index] > arr[index-1]+1){
                    margin = arr[index]-arr[index-1]-1;
                }
            }
        }

        if(numZero >= margin){
            System.out.println("the continue is true");
        }else{
            System.out.println("the continue is false");
        }
    }

    //冒泡排序

    /**
     * 冒泡排序优化版本：
     * 如果第二层没有发生过交换，那么说明已经是排好序的，可以提前终止程序了
     * @param arr
     */
    private static void sort(int[] arr){
        for(int i=1;i<arr.length;i++){
            for(int j = 0;j<arr.length-i;j++){
                //交换
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
