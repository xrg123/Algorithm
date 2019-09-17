package mutileThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class producerAndConsumer3 {
    private static int count = 0;
    private static int full = 10;
    private static Lock lock = new ReentrantLock();
    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();

    public static void main(String[] args) {
        System.out.println("启动生产者、消费者模式");
        for (int i = 0; i < 10; i++) {
            new Thread(new Producer()).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(new Consumer()).start();
        }

    }

    static class Producer implements Runnable {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    lock.lock();
                    if (count == full)
                        condition1.await();
                    count++;
                    System.out.println("当前线程：" + Thread.currentThread().getName() + " 生产者");
                    condition2.signalAll();
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
                    lock.lock();
                    if (count == 0)
                        condition2.await();
                    count--;
                    System.out.println("当前线程：" + Thread.currentThread().getName() + " 消费者");
                    condition1.signalAll();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
