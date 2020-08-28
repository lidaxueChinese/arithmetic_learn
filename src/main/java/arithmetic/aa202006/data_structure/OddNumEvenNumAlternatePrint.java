package arithmetic.aa202006.data_structure;
/**
 * Created by lidaxue on 2020/8/28.
 * 奇数 偶数 交替 打印
 *
 * wait和 notify 的使用
 * 作用： 可以用于线程间的通信
 */
public class OddNumEvenNumAlternatePrint {


    private synchronized void oddNumPrint(int value) throws Exception{
        System.out.println(Thread.currentThread().getName()+" print value :"+value);
        this.notify();
        this.wait();
    }

    private synchronized void evenNumPrint(int value) throws Exception{
        System.out.println(Thread.currentThread().getName()+" print value :"+value);
        this.notify();
        this.wait();
    }




    public static void main(String[] args) throws Exception{
        OddNumEvenNumAlternatePrint obj = new OddNumEvenNumAlternatePrint();
        Thread oddThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int value = 1;
                    while(value<=100){
                        obj.oddNumPrint(value);
                        value +=2;
                    }

                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        },"odd");
        oddThread.start();


        Thread conThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    int value = 2;
                    while(value<=100){
                        obj.oddNumPrint(value);
                        value +=2;
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        },"even");

        conThread.start();




    }



}
