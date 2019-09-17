package mutileThread;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Test {
    public static int index = 0;
    public static String Lock = "lock";

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        System.out.println(set.add(1));
        System.out.println(set.add(1));
    }

    static class PrintOne implements Runnable {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    synchronized (Lock) {
                        if (index % 2 != 0) {
                            Lock.wait();
                        }
                        index++;
                        System.out.println(index);
                        Lock.notify();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class PrintTwo implements Runnable {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    synchronized (Lock) {
                        if (index % 2 == 0)
                            Lock.wait();
                        index++;
                        System.out.println(index);
                        Lock.notify();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
