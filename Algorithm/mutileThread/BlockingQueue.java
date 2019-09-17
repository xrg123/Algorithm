package mutileThread;

import javax.smartcardio.TerminalFactory;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueue {
    public static void main(String[] args) {
        LinkedBlockingQueue shareQueue = new LinkedBlockingQueue();
        //单生产者，单消费者
        /*new Thread(new Producer(shareQueue)).start();
        new Thread(new Consumer(shareQueue)).start();*/
        //多生产者、多消费者
        for (int i = 0; i < 10; i++) {
            new Thread(new Producer(shareQueue)).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(new Consumer(shareQueue)).start();
        }

    }

    static class Producer implements Runnable {
        private LinkedBlockingQueue shareQueue;

        public Producer(LinkedBlockingQueue queue) {
            shareQueue = queue;
        }

        public void run() {
            int index = 0;
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println("生产者生产:" + index);
                    shareQueue.put(index);
                    index++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        LinkedBlockingQueue shareQueue;

        public Consumer(LinkedBlockingQueue queue) {
            shareQueue = queue;
        }

        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println("消费者:" + shareQueue.take());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
