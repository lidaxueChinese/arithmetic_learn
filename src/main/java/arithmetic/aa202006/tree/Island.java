package arithmetic.aa202006.tree;
/**
 * Created by lidaxue on 2020/8/14.
 * 岛屿问题
 * 链接：https://leetcode-cn.com/problems/number-of-islands/
 *
 *
 *注意点:
 * 1. 对一个arr[][]获取行数--表示外层list，rNum = arr.length；列数--表示内层list ,cNum= arr[0].length
 *
 *
 * 2. 重点：arr[r][c] 解读是先获取外层的list即arr[r] ，再取内层list即[c]。。。容易将arr[x][x]读取看到"矩阵"图像的样子，需要手动转义下
 *
 * 3. r+1 和 r--  要注意。因为是用r-- 会改变r本身值
 *
 * 4.islandTintage(arr,r-1,c);等情况的出现是 从右边 -->往下--> 和左边串联在一起..做左右下上相连的需要合并在一起
 * 1,1,1
 * 0,1,0
 * 1,1,1
 *
 *
 * 时间复杂度：m*n+ 4*m*n ,总体来说是O(m*n)
 * 空间复杂度：计算需要额外花费的为O(1)??
 */
public class Island {

    public static void main(String[] args) {
        char[][] arr = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','0','1','0','0'},
                {'0','0','0','0','1'}
          };
        Island island = new Island();
        int num = island.getIslandNum(arr);
        System.out.println("the num is:"+num);
    }

    private void islandTintage(char[][] arr,int r,int c){
        int rNum = arr.length;
        int cNum = arr[0].length;
        if(r<0 || c<0 || r>=rNum || c>=cNum || arr[r][c]=='0'){
            return;
        }
        arr[r][c] = '0';
        islandTintage(arr,r-1,c);
        islandTintage(arr,r+1,c);
        islandTintage(arr,r,c-1);
        islandTintage(arr,r,c+1);
    }
    private int getIslandNum(char[][] arr){
        int num = 0;
        //
        for(int r = 0;r<arr.length;r++){ //外层arr
            for(int c=0;c<arr[0].length;c++) { //里层arr
                try {
                    if (arr[r][c] == '1') {
                        num++;
                        islandTintage(arr, r, c);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return num;
    }

    /*
    int rNum = 5;
    int cNum = 4;
    int num = 0;
    private void islandNum(int[][] islandArr,int r,int c,boolean needSetHead){
        //数组越界
      if(r< 0 ||r >= rNum || c < 0 ||c>= cNum){
            return;
      }
      int value = islandArr[r][c];
      if(needSetHead){
          if(value == 1){ //找到起始点
              num ++;
              islandArr[r][c] = 0;
              //islandNum(islandArr,r--,c,!needSetHead);
              islandNum(islandArr,r++,c,!needSetHead);

              islandNum(islandArr,r,c++,!needSetHead);
              //islandNum(islandArr,r,c--,!needSetHead);

              //TODO 执行到这说明已经碰到了"围墙"
              //优化点：遇到"围墙"后，下一个起点在什么地方
              //islandNum(islandArr,r++,c,needSetHead);
              //islandNum(islandArr,r,c++,needSetHead);

          }else{
              islandNum(islandArr,r++,c,needSetHead);
              islandNum(islandArr,r,c++,needSetHead);
          }
      }else{ //已经有头的情况下
          if(value == 1){
              islandArr[r][c] = 0;
              //往下
              islandNum(islandArr,r++,c,needSetHead);

              //往右
              islandNum(islandArr,r,c++,needSetHead);

          }else{

          }
      }

    }*/



}
