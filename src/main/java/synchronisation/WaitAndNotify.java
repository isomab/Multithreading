package synchronisation;

public class WaitAndNotify {
    public static Object lock = new Object();

    public static void main(String[] args) {

        Thread one = new Thread(() -> {
            try {
                one();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread two = new Thread(() -> {
            try {
                two();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        one.start();
        two.start();

    }

    public static void one() throws InterruptedException {
        synchronized (lock) {
            System.out.println("Thread one is called before wait");
            lock.wait();
            System.out.println("After notify");
        }

    }

    public static void two() throws InterruptedException {
        synchronized (lock) {
            System.out.println("Method two is called by thread two after wait is being called by thread one.");
            lock.notify();
            System.out.println("Method two is finished");
        }

    }


}

/*
In the above case two threads are created and two methods are being called separately by those threads
only one lock is used. so we use wait and notify for inter thread communication.
as only one lock is available only one thread will be available to execution.
By calling lock.wait() thread can go into wait state. and other thread can activate for execution
once the other thread calls notify method i.e lock.notify. it will handover lock to other thread.
 */
