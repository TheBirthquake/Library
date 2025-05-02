package module4.livelockexample;

public class LivelockMain {

    public static void main(String[] args) {
        // Create the diners
        final Diner alphonse = new Diner("Alphonse");
        final Diner gaston = new Diner("Gaston");

        // Create the shared spoon, initially owned by Alphonse
        final Spoon spoon = new Spoon(alphonse);

        // Create threads for each diner
        Thread alphonseThread = new Thread(new Runnable() {
            @Override
            public void run() {
                alphonse.eatWith(spoon, gaston);
            }
        });

        Thread gastonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                gaston.eatWith(spoon, alphonse);
            }
        });

        // Start the threads
        alphonseThread.start();
        gastonThread.start();

        // The program will likely run indefinitely in a livelock
        System.out.println("Main thread finished. Livelock scenario started.");
    }
}
