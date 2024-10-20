package basicmultithreading;

public class ThreadPriorityExample {
    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("From main thread : " + i);
            }
        });
        Thread thread2 = new Thread(new PriorityThread());
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        thread2.start();
    }
}

class PriorityThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("From priority thread : " + i);
        }
    }
}
