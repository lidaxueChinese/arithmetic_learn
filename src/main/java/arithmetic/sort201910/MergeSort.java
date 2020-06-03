package arithmetic.sort201910;
/** 并归排序
 *  Created by 10718 on 2019/11/1.
 *  并归排序  int middle = (left+right)/2 ,根据此条件递归的次数是 log2 N
 *  每次处理时间复杂度: merge, 将排序的值赋给assistArr以及最后 assistArr回放到原生数组，为2n
 *  空间复杂度：需要一个辅助数据大小为n
 */
public class MergeSort {

    private  int[] assistArr = null;
    public MergeSort(int arrSize){
        assistArr = new  int[arrSize];
    }

    private  void sort(int[] arr,int left,int right){

          if (left<right) {
              int middle = (left + right) / 2;
              sort(arr, left, middle);
              sort(arr, middle + 1, right);
              merge(arr, left, right);
          }

    }

    private  void merge(int[] arr,int left,int right){
            int index = 0;
            int middle = (left+right)/2;
            int tempLeft = left;
            int tempRight = middle+1;
            while(tempLeft <= middle && tempRight<=right){
                if(arr[tempLeft] <= arr[tempRight]){
                    assistArr[index] = arr[tempLeft];
                    tempLeft ++;
                }else{
                    assistArr[index] = arr[tempRight];
                    tempRight ++;
                }
                index ++;
            }

            while(tempLeft <= middle){
                assistArr[index] = arr[tempLeft];
                tempLeft ++;
                index ++;
            }

            while(tempRight <= right){
                assistArr[index] = arr[tempRight];
                tempRight ++;
                index ++;
            }

            //将辅助数组的值copy到原来的数组中
            index = 0;
           for(int i = left;i<=right;i++){
                arr[i] = assistArr[index];
                index++;
           }
    }

    public static void main(String[] args) {

        int[] arr = {9,4,3,7,8,5,6}; //7,8,5,6
        if(arr != null && arr.length > 1) {
            MergeSort mergeSort = new MergeSort(arr.length);
            mergeSort.sort(arr, 0, arr.length - 1);
        }
        System.out.println("the arr");
    }
}
