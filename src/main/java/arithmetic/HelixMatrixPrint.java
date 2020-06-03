package arithmetic;
/** 螺旋矩阵打印
 * 1  2  3  4
 * 5  6  7  8
 * 9  10 11 12
 *
 * 历时三个多小时 加上参考其他blog的思路（https://blog.csdn.net/m0_37316917/article/details/86937430），手动的写出来吧
 * 疑难点：
 * 1. 理解int[][] 数据的含义，可以理解为 前一个int[]表示正常数组的一个元素，后面再加一个[]表示该元素是个数组可以按照索引取值
 * 2. 向左遍历 以及 向右遍历 ,怎么对应。 向左右遍历 是第一个[], 向上下 遍历 是第二个[].
 * 3. 每次遍历 完成后row_xx 或者 col_xx 都会进行相应的加减
 */
public class HelixMatrixPrint {

    //row 3  ; col 4
    private static void print(int[][] arr,int row,int col){
        int row_up = 0;
        int row_down = row-1;
        int col_left = 0;
        int col_right = col-1;
        while(true){

            //1
            if(col_left <= col_right){
                for(int index = col_left;index <= col_right;index++){
                    System.out.println(arr[index][row_up]);
                }
                row_up++;
            }else{
                break;
            }

            //2
            if(row_up <= row_down){
                for(int index = row_up;index <= row_down;index++){
                    System.out.println(arr[col_right][index]);
                }
                col_right --;
            }else{
                break;
            }

            //3
            if(col_left <= col_right){
                for(int index = col_right;index >= col_left;index--){
                    System.out.println(arr[index][row_down]);
                }
                row_down --;
            }else{
                break;
            }

            //4
            if(row_up <= row_down){
                for(int index = row_down;index >= row_up;index--){
                    System.out.println(arr[col_left][index]);
                }
                col_left ++;
            }else{
                break;
            }
        }

    }

    public static void main(String[] args) {
         int[] col1 = {1,5,9};
         int[] col2 = {2,6,10};
         int[] col3 = {3,7,11};
         int[] col4 = {4,8,12};
         int[][] arr = {col1,col2,col3,col4};
         print(arr,3,4);
    }

}
