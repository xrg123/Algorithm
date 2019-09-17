package mutileThread;

public class producerAndConsumer1 {
    private static int count = 0;
    private static int full = 1;
    private static String Lock = "lock";

    public static void main(String[] args) {
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
                    synchronized (Lock) {
                        //此处用while的原因
                        //用if的话被唤醒后直接执行count加或减的操作，会产生outOfBound异常
                        while (count == full) {
                            Lock.wait();
                        }
                        count++;
                        System.out.println("当前线程为：" + Thread.currentThread().getName() + " 进行生产");
                        Lock.notifyAll();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    synchronized (Lock) {
                        while (count == 0) {
                            Lock.wait();
                        }
                        count--;
                        System.out.println("当前线程为：" + Thread.currentThread().getName() + " 进行消费");
                        Lock.notifyAll();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
