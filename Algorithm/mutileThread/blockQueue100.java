package mutileThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class blockQueue100 {
    private static Object[] items = new Object[100];
    private static int count = 0;
    private static int full = 0;
    private static int putIndex = 0;
    private static int getIndex = 0;
    private static Lock lock = new ReentrantLock();
    private static Condition notEmpty = lock.newCondition();
    private static Condition notFull = lock.newCondition();

    public static void put (Object o) {
        try {
            while (count == full)
                notFull.await();
            items[putIndex] = o;
            if (++putIndex == count) {
                putIndex = 0;
            }
            count++;
            notEmpty.signalAll();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static Object take() {
        Object object = null;
        try {
            lock.lock();
            while (count  == 0)
                notEmpty.await();
            object = items[getIndex];
            if (++getIndex == full)
                getIndex = 0;
            count--;
            notFull.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
        return object;
    }
}
