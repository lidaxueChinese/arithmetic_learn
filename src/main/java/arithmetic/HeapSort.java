package arithmetic;

/**
 * Created by ldxPC on 2018/10/23.
 */
public class HeapSort {

    private int getLeftChildIndex(int p){
         return 2*p+1;
    }
    private int getRightChildIndex(int p){
        return 2*p+2;
    }

    private int getParentIndex(int c){
        return (c-1)/2;
    }
    public void siftUp(int[] date){
          for(int i = 1 ;i<date.length;i++){
               int siftIndex = i;
               while(siftIndex>0 && date[getParentIndex(siftIndex)] > date[siftIndex]){
                    //swap
                    int tempValue = date[siftIndex];
                    date[siftIndex] = date[getParentIndex(siftIndex)];
                    date[getParentIndex(siftIndex)]= tempValue;
                   siftIndex = getParentIndex(siftIndex);
               }
          }
    }

    /**
     *
     * @param date
     * @param length 表示date的前多少个元素需要进行heap调整
     */
    public void siftDown(int[] date,int length){
         for(int i = 0;i<length;i++){
               int siftIndex = i;
              while(getLeftChildIndex(siftIndex) < length){
                    int lessChildIndex = getLeftChildIndex(siftIndex);
                    if(getRightChildIndex(siftIndex) < length){
                          if(date[getRightChildIndex(siftIndex)] < date[getLeftChildIndex(siftIndex)]){  //更小的child 是右节点,将lessChild+1
                               lessChildIndex++ ;
                          }
                    }

                    if(date[lessChildIndex] < date[siftIndex]){  //child节点比changeIndex节点小
                         int tempValue = date[siftIndex];
                         date[siftIndex] = date[lessChildIndex];
                         date[lessChildIndex] = tempValue;
                        siftIndex = lessChildIndex;
                    }else{
                        break;
                    }
              }
         }
    }

    public static void main(String[] args){

         int[] date = {4,3,6,1,79,4,7,32,1,33,14,64,68,35};

         System.out.println("数组调整前:"+printDate(date));

          HeapSort heapSort = new HeapSort();
          heapSort.siftUp(date); //构建堆

          for(int n = date.length-1;n>1;n--){
                 int lessValue = date[0];
                 date[0] = date[n];
                 date[n] = lessValue;

                 heapSort.siftDown(date,n-1); //对前n-1个数进行调整

          }

        System.out.println("数组调整后:"+printDate(date));

    }

    public static String printDate(int[] date){
        StringBuilder builder = new StringBuilder();
        for(int i = 0;i<date.length;i++){
             if(i >0){
                 builder.append(",").append(date[i]);
             }else{
                 builder.append(date[i]);
             }
        }

        return builder.toString();
    }
}
