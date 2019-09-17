package mutileThread;

/**
 * 单生产者、
 * 单消费者
 */
public class producerAndConsumer {
    private static int count = 0;
    private static int full = 10;
    private static String Lock = "lock";

    public static void main(String[] args) {
        System.out.println("启动生产者、消费者模式");
        Thread producer = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        synchronized(Lock) {
                            if (count == full) {
                                Lock.wait();
                            }
                            count++;
                            System.out.println("生产");
                            Lock.notify();
                        }
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread consumer = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        synchronized (Lock) {
                            if (count == 0) {
                                Lock.wait();
                            }
                            count--;
                            System.out.println("消费");
                            Lock.notify();
                        }
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        producer.start();
        consumer.start();
    }
}
