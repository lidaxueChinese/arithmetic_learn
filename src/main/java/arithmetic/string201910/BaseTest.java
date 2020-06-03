package arithmetic.string201910;

import java.util.ArrayList;

/**
 * Created by 10718 on 2019/10/23.
 */
public class BaseTest {

    public static void main(String[] args) {
        Object[] arr=new Object[]{"1","a","b"};
        ArrayList<Object[]> result=new ArrayList<Object[]>();
        perm(arr,0,arr.length,result);
        //输出集合中的数组元素
        for (Object[] o:result){
            for (int i=0;i<o.length;i++){
                System.out.print(o[i]+" ");
            }
            System.out.println();
        }

    }

    public static void perm(Object[] arr, int k, int length, ArrayList<Object[]> result) {
        //只有一个数，则排列确定，将该数组保存在集合中
        if (k==length-1){
            Object[] b=arr.clone();
            result.add(b);
        }else {
            for (int i=k;i<length;i++){
                if (IsSwap(arr,k,i)) {
                    swap(arr, k, i);
                    perm(arr, k + 1, length,result);
                    swap(arr, k, i);
                }
            }
        }
    }

    private static boolean IsSwap(Object[] arr, int begin, int end) {
        for (int i=begin;i<end;i++)
            if (arr[i]==arr[end])return false;
        return true;
    }

    private static void swap(Object[] arr, int k, int i) {
        Object temp;
        temp=arr[k];
        arr[k]=arr[i];
        arr[i]=temp;
    }


}
