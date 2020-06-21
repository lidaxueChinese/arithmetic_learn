package arithmetic.sort201910;
/**快速排序
 * 普通的排序 时间复杂度是 n*n
 * 第一个n表示：需要排n次； 第二个n表示每次需要排n个元素
 * 而快速排序的方案就是减少排序的次数，即减少第一个n
 * Created by 10718 on 2019/10/22.
 */
public class QuickSort {

   private static void sort(int arr[],int startIndex,int endIndex){
       quickSort(arr,startIndex,endIndex);

       /*int partitionIndex = getPartitionIndex1(arr,startIndex,endIndex);
       System.out.println("partitionIndex is:"+partitionIndex);
       if(partitionIndex-1 > startIndex) {
           sort(arr, startIndex, partitionIndex - 1);
       }
       if(endIndex > partitionIndex+1) {
           sort(arr, partitionIndex + 1, endIndex);
       }*/
   }

    /**
     *感觉更容易理解一些
     */
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


    private static int getPartitionIndex1(int[] arr,int startIndex ,int endIndex){

        int partitionIndex = startIndex;
        int partitionValue = arr[startIndex];

        while(startIndex <= endIndex){

            while(startIndex <= endIndex){
                if(arr[endIndex] >= partitionValue){
                    endIndex --;
                }else{
                    arr[partitionIndex] = arr[endIndex];
                    partitionIndex  = endIndex;
                    endIndex --;
                    break;
                }
            }
            while(startIndex <= endIndex){
                if(arr[startIndex] <= partitionValue){
                    startIndex ++;
                }else{
                    arr[partitionIndex] = arr[startIndex];
                    partitionIndex = startIndex;
                    startIndex ++;
                    break;
                }
            }
        }

        arr[partitionIndex] = partitionValue;
        return partitionIndex;

    }

    private static void quickSort(int[] arr,int startIndex ,int endIndex){

        int startIndexOri = startIndex;
        int endIndexOri = endIndex;
        int partitionIndex = startIndex;
        int partitionValue = arr[startIndex];

        while(startIndex <= endIndex){

            while(startIndex <= endIndex){
                if(arr[endIndex] >= partitionValue){
                    endIndex --;
                }else{
                    arr[partitionIndex] = arr[endIndex];
                    partitionIndex  = endIndex;
                    endIndex --;
                    break;
                }
            }
            while(startIndex <= endIndex){
                if(arr[startIndex] <= partitionValue){
                    startIndex ++;
                }else{
                    arr[partitionIndex] = arr[startIndex];
                    partitionIndex = startIndex;
                    startIndex ++;
                    break;
                }
            }
        }

        arr[partitionIndex] = partitionValue;
        if(partitionIndex-1 > startIndexOri) {
            quickSort(arr, startIndexOri, partitionIndex - 1);
        }
        if(endIndexOri > partitionIndex+1) {
            quickSort(arr, partitionIndex + 1, endIndexOri);
        }

    }




    public static void main(String[] args) {
        int[] temp = {9,9,8,7,5,10,4,3,2,1,11,-2,0,-1};

        if(temp != null && temp.length > 1) {
            sort(temp, 0, temp.length - 1);
        }
        for(int i = 0;i<temp.length;i++){
            System.out.println(temp[i]);
        }
    }
}
