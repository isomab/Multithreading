package synchronisation;

public class ProblemWithSynchronization {
    private static int counter = 0;
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread one = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment1();
            }
        });
        Thread two = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment1();
            }
        });

        one.start();
        two.start();

        one.join();
        two.join();

        System.out.println("Counter is : " + counter);

    }


    //When both threads call this method the intrinsic lock is available for only one thread the other
    //Threads goes into wait & will only get's lock when first thread releases lock after it's execution.
    //Intrinsic lock is at class level.
    //Even if you write separate increment method for both threads the lock will be only in this case
    //To avoid this you can write specific code in synchronized block and use custom lock
    private synchronized static void increment() {
        counter++;
    }


    //Thread one will acquire lock1 and excutes.
    private static void increment1() {
        synchronized (lock1) {
            counter++;
        }
    }

    //Thread two will acquire lock2 and execute
    private static void increment2() {
        synchronized (lock2) {
            counter++;
        }
    }
}
