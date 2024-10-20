package basicmultithreading;

public class DaemonHelper {
    public static void main(String[] args) {

        Thread bgThread = new Thread(new daemonThread());
        Thread userThread = new Thread(new userThread());

        bgThread.setDaemon(true);//when setDaemon is true.it converts userthread to daemon thread with low priority.
        bgThread.start();
        userThread.start();
    }
}

class daemonThread implements Runnable {

    @Override
    public void run() {
        int count = 0;
        while (count < 500) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Daemon thread running in the background");
        }
    }
}

class userThread implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("User thread started will go into sleep state for 5 sec");
            Thread.sleep(5000);         //while user thread in sleep state daemon thread will run in background.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("User thread finished");
    }
}
