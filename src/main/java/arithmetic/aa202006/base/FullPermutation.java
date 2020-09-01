package arithmetic.aa202006.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lidaxue on 2020/9/1.
 *
 * 对一串数进行全排序
 *
 * 时间复杂度：根据公式计算：fullSort(n) = n * fullSort(n-1)  推导出 fullSort(n) = n * (n-1) * fullSort(n-2),总体来说n！ （n 的阶乘）
 * 空间复杂度： 第一次计算需要空间 n* size(有多少条子列表) * (n-1)(表示子列表 每条大小为n-1)
 *
 * 先定位第一个元素,通过交换的方式，将第一个 分别和 第二位、第三位 ... 进行交换，剩下的元素得到子元素所有可能性的list<String>，然后将
 * 第一个元素拼接在一起
 */
public class FullPermutation {


    public static void main(String[] args) {
        FullPermutation fullPermutation = new FullPermutation();
        List<String> eleList = new ArrayList<>();
        eleList.add("a");
        eleList.add("b");
        eleList.add("c");
        eleList.add("d");
        List<String> result =  fullPermutation.fullSort(eleList);
        System.out.println("the result is:"+result);
    }
    private List<String> fullSort(List<String> eleList){

        if(eleList.size() == 1){
            return eleList;
        }
        List<String> mergeList = new ArrayList<>();
        for(int i = 0;i< eleList.size();i++){
            swap(0,i,eleList);
            String firstEle = eleList.get(0);
            List<String> remainEleList = eleList.subList(1,eleList.size());
            List<String> remainList = fullSort(remainEleList);
            for(int rIndex = 0;rIndex<remainList.size();rIndex++){
                mergeList.add(firstEle+remainList.get(rIndex));
            }
            swap(i,0,eleList);

        }
        return mergeList;
    }


    private void swap(int ori,int update,List<String> eleList){
        String oriValue = eleList.get(ori);
        eleList.set(ori,eleList.get(update));
        eleList.set(update,oriValue);
    }
}
