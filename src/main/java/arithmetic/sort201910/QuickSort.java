package arithmetic.sort201910;
/**快速排序
 * 普通的排序 时间复杂度是 n*n
 * 第一个n表示：需要排n次； 第二个n表示每次需要排n个元素
 * 而快速排序的方案就是减少排序的次数，即减少第一个n
 * Created by 10718 on 2019/10/22.
 */
public class QuickSort {

   private static void sort(int arr[],int startIndex,int endIndex){
       int partitionIndex = getPartitionIndex(arr,startIndex,endIndex);
       if(partitionIndex-1 > startIndex) {
           sort(arr, startIndex, partitionIndex - 1);
       }
       if(endIndex > partitionIndex+1) {
           sort(arr, partitionIndex + 1, endIndex);
       }
   }

    private static int getPartitionIndex(int[] arr,int startIndex,int endIndex){
        int combineValue = arr[startIndex];
        while(startIndex < endIndex){
           /*while(startIndex < endIndex && arr[endIndex]>combineValue){
               endIndex --;
           }
           if(startIndex < endIndex){
               arr[startIndex] = arr[endIndex];
               startIndex ++;
           }*/
           while(startIndex < endIndex){
               if(arr[endIndex]>combineValue){
                   endIndex --;
               }else{
                   arr[startIndex] = arr[endIndex];
                   startIndex ++;
                   break;
               }
           }
           /*while(startIndex < endIndex && arr[startIndex] < combineValue){
               startIndex ++;
           }
           if(startIndex < endIndex){
               arr[endIndex] = arr[startIndex];
               endIndex --;
           }*/
           while (startIndex < endIndex){
               if(arr[startIndex] < combineValue){
                   startIndex++;
               }else{
                   arr[endIndex] = arr[startIndex];
                   endIndex--;
                   break;
               }
           }
        }
        arr[startIndex]=combineValue;
        return startIndex;
    }

    public static void main(String[] args) {
        int[] temp = {10,5};
        if(temp != null && temp.length > 1) {
            sort(temp, 0, temp.length - 1);
        }
        for(int i = 0;i<temp.length;i++){
            System.out.println(temp[i]);
        }
    }
}
