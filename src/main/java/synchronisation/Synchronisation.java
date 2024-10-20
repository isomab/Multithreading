package synchronisation;

public class Synchronisation {
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread one = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });

        Thread two = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });

        one.start();
        two.start();

        one.join();//calling join to finish it's execution before main thread executes next line.
        two.join();

        //The counter will be correct as race condition is avoided by using synchronized keyword
        System.out.println("Counter : " + counter);

    }

    //To prevent race condition we can use synchronized keyword which will allow only one thread.
    //at a time to access below method
    private synchronized static void increment() {
        counter++;
    }

}
