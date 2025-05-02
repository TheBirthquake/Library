package module4.deadlockexample;

public class ThreadOne extends Thread {
    private ResourceA resourceA;
    private ResourceB resourceB;

    public ThreadOne(ResourceA resourceA, ResourceB resourceB) {
        this.resourceA = resourceA;
        this.resourceB = resourceB;
    }

    @Override
    public void run() {
        // Synchronize on resourceA first
        synchronized (resourceA) {
            System.out.println("Thread One: Acquired " + resourceA.getName());

            // Introduce a small delay to increase the chance of deadlock
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Then try to acquire resourceB
            synchronized (resourceB) {
                System.out.println("Thread One: Acquired " + resourceB.getName());
                // Perform operations with both resources
                System.out.println("Thread One: Performing action with both resources.");
            } // resourceB lock released
        } // resourceA lock released
    }
}
