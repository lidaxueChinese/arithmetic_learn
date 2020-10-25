package arithmetic.aa202006.sort;
/**
 * Created by lidaxue on 2020/10/25.
 * 冒泡排序
 */
public class BubblingSort {

    public static void main(String[] args) {
        BubblingSort bubblingSort = new BubblingSort();
        int[] arr = new int[]{1,2,3,4,5};//new int[]{5,4,3,2,1};
        bubblingSort.sort(arr);
        for(int index = 0 ;index < arr.length;index++){
            System.out.println("the value is:"+arr[index]);
        }
    }
    public void sort(int[] arr){
        boolean isSort = false;
        for(int i = 0;i<arr.length;i++){
            //TODO 优化点：如果在遍历的过程中，没有出现交换的过程，说明已经是排好序的，可以直接退出
            if(isSort){
                break;
            }
            //每次排序前，先将sort重置为true;
            isSort =true;
            System.out.println("ite the arr ....");
            //至少要包含当前元素 和下一个元素
            for(int j = 0;j<arr.length-i-1;j++){
              if(arr[j] > arr[j+1]){
                  int swapValue = arr[j+1];
                  arr[j+1] = arr[j];
                  arr[j] = swapValue;
                  isSort = false;
              }
            }
        }
    }

}
