package arithmetic;

/**
 * Created by ldxPC on 2018/11/1.
 *
 * java.lang.Object类中主要提供了两个用于线程通信的方法 wait() 和 notify()
 *
 * 参考文档
 */
public class OddEvenNumberPrint2 {


    private int num = 1;
    private synchronized void printOdd() throws InterruptedException{
          System.out.println("the odd num:"+num);
          num ++;
          this.notify();
          this.wait();

    }

    private synchronized  void printEven() throws InterruptedException{
        System.out.println("the even num:"+num);
        num ++;
        this.notify();

        /**This method causes the current thread (call it <var>T</var>) to
                 place itself in the wait set for this object and then to relinquish
                 any and all synchronization claims on this object

         **/
         //即调用wait后会释放关于改对象的monitor ,并且不会在
        this.wait();
    }


    public int getNum(){
        return num;
    }



    public static void main(String[] args){
         OddEvenNumberPrint2 obj = new OddEvenNumberPrint2();
         Thread oddThread = new Thread(new Runnable() {
             @Override
             public void run() {
                 while(obj.getNum() <=100){
                     try {
                         obj.printOdd();
                     }catch (InterruptedException e){
                         e.printStackTrace();
                     }
                 }

             }
         });

        oddThread.start();


        Thread evenThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(obj.getNum() <=100){
                    try {
                        obj.printEven();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }

            }
        });


        evenThread.start();



    }



}
