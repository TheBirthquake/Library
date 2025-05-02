package module4.deadlockexample;

public class ThreadTwo extends Thread {
    private ResourceA resourceA;
    private ResourceB resourceB;

    public ThreadTwo(ResourceA resourceA, ResourceB resourceB) {
        this.resourceA = resourceA;
        this.resourceB = resourceB;
    }

    @Override
    public void run() {
        // Synchronize on resourceB first
        synchronized (resourceB) {
            System.out.println("Thread Two: Acquired " + resourceB.getName());

            // Introduce a small delay to increase the chance of deadlock
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Then try to acquire resourceA
            synchronized (resourceA) {
                System.out.println("Thread Two: Acquired " + resourceA.getName());
                // Perform operations with both resources
                System.out.println("Thread Two: Performing action with both resources.");
            } // resourceA lock released
        } // resourceB lock released
    }
}
