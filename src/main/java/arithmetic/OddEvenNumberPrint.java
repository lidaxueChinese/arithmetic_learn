package arithmetic;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ldxPC on 2018/10/27.
 *
 * 用于奇偶数的打印
 */
public class OddEvenNumberPrint {

    static ReentrantLock reentrantLock = new ReentrantLock();

    static Condition oddCon = reentrantLock.newCondition();

    static  Condition evenCon = reentrantLock.newCondition();

    static int printValue =1;


    private static class OddThread implements Runnable{
        @Override
        public void run() {
            while(true) {
                try {
                    reentrantLock.lock();
                    System.out.println("the odd value:"+printValue);
                    printValue ++ ;
                    //通知even 数 打印
                    evenCon.signal();

                    if(printValue <= 100){
                        //等待...
                        oddCon.await();
                    }else{
                        break;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
        }
    }

    private static class EvenThread implements Runnable{
        @Override
        public void run() {
            while(true) {
                try {
                    reentrantLock.lock();
                    System.out.println("the even value:"+printValue);
                    printValue ++ ;
                    //通知even 数 打印
                    oddCon.signal();

                    //等待...
                    if(printValue <= 100){
                        evenCon.await();
                    }else{
                        break;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
        }
    }


    public static void main(String[] args) throws  Exception{
        Thread oddThread = new Thread(new OddThread());
        oddThread.start();
        Thread.sleep(300);
        Thread evenThread = new Thread(new EvenThread());
        evenThread.start();
    }
}
