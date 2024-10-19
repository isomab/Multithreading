package basicmultithreading;

public class ExtendClassExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());
        thread1.start();
        thread2.start();

    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("From thread 1 " + i);
        }
    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        for (int i = 6; i <= 10; i++) {
            System.out.println("From thread 2 " + i);
        }
    }
}
