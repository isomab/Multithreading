package synchronisation;

public class WithoutSynchronisation {
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread one = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter++;
            }
        });

        Thread two = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter++;
            }
        });

        one.start();
        two.start();

        one.join();//calling join to finish it's execution before main thread executes next line.
        two.join();

        //The counter will not be correct as race condition is occured
        System.out.println("Counter : " + counter);

    }
}


/*
*counter=0 Shared resource
*load
*increment
*set back value

* Counter=0; incremented=1; Setting back value to counter=1 (before it sets the thread two is accessed to counter=0)   << Thread one
* Counter=0; incremented=1   << Thread two

Thread one is loaded and incremented to 1 but before set it to  counter =1 thread 2 comes into picture and access
counter which value is still 0 and it also increment counter to 1 in the meantime thread one is set value
counter =1 and then thread two also overwrite value counter =1. in real counter should be counter =2

* This above scenario is called RACE condition
* To avoid above race condition we can use synchronisation
 */