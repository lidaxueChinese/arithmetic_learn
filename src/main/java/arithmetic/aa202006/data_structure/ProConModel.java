package arithmetic.aa202006.data_structure;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lidaxue on 2020/8/31.
 *
 * notFull 和 notEmpty 记忆法
 *
 * await 表示否定，assign 表示肯定
 *
 * notFull.await 表示 not 否定  full==> full
 *
 *
 * Conditition 作用: 可以有"选择性"的 通知 哪些正在“等待”中的线程
 */
public class ProConModel {

    private int capacity = 2;
    LinkedList<String> linkedList = new LinkedList<String>();

    ReentrantLock lock = new ReentrantLock();
    Condition notFull = lock.newCondition(); //对应producer
    Condition notEmpty = lock.newCondition();//对应consumer


    private void producer(String element) throws InterruptedException{
      try{
          lock.lock();
          while(isFull()){
              System.out.println(Thread.currentThread().getName()+" the link is full. the producer await");
              notFull.await();
          }

          linkedList.add(element);
          System.out.println(Thread.currentThread().getName()+" producer value:"+element);
          notEmpty.signal();

      }finally {
          lock.unlock();
      }
    }


    private String consumer() throws InterruptedException{
        try{
           lock.lock();
           while(isEmpty()){
               System.out.println(Thread.currentThread().getName()+" the link is empty.the consumer await");
               notEmpty.await();
           }
           String ele  = linkedList.poll();
           System.out.println(Thread.currentThread().getName()+" consumer value:"+ele);
           notFull.signal();
           return ele;
        }finally {
            lock.unlock();
        }
    }

    private boolean isFull(){
        if(linkedList.size() == capacity){
            return true;
        }else{
            return false;
        }
    }

    private boolean isEmpty(){
        if(linkedList.size() == 0){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ProConModel proConModel = new ProConModel();

        Thread proThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i <= 20; i++) {
                        proConModel.producer(new Integer(i).toString());
                        int sTime = new Double(Math.random() * 50).intValue();
                        Thread.sleep(sTime);
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"producer-thread");

        Thread conThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i <= 20; i++) {
                        proConModel.consumer();
                        int sTime = new Double(Math.random() * 50).intValue();
                        Thread.sleep(sTime);
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"consumer-thread");

        proThread.start();
        conThread.start();
    }

}
