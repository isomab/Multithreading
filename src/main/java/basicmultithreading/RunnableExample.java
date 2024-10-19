package basicmultithreading;

public class RunnableExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ThreadRunnable1());
        Thread thread2 = new Thread(new ThreadRunnable2());

        //Using lambda expression
        Thread thread3 = new Thread(() ->
        {
            for (int i = 11; i <= 15; i++) {
                System.out.println("For thread 3 " + i);
            }
        }
        );

        thread1.start();
        thread2.start();
        thread3.start();


    }
}

class ThreadRunnable1 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("For thread 1 " + i);
        }
    }
}

class ThreadRunnable2 implements Runnable {
    @Override
    public void run() {
        for (int i = 6; i <= 10; i++) {
            System.out.println("For thread 2 " + i);
        }
    }
}