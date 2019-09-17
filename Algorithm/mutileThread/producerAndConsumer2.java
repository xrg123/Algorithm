package mutileThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class producerAndConsumer2 {
    private static int count = 0;
    private static int full = 10;
    private static Lock lock = new ReentrantLock();
    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();

    public static void main(String[] args) {
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }

    static class Producer implements Runnable {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    lock.lock();
                    if (count == full) {
                        condition1.await();
                    }
                    count++;
                    System.out.println("当前线程为：" + Thread.currentThread().getName() + " 进行生产");
                    condition2.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    lock.lock();
                    if (count == 0) {
                        condition2.await();
                    }
                    count--;
                    System.out.println("当前线程为：" + Thread.currentThread().getName() + " 进行消费");
                    condition1.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
