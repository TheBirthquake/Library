package module4.deadlockexample;

public class DeadlockMain {

    public static void main(String[] args) {
        // Create the two resources
        ResourceA resourceA = new ResourceA();
        ResourceB resourceB = new ResourceB();

        // Create the two threads, passing the resources
        ThreadOne threadOne = new ThreadOne(resourceA, resourceB);
        ThreadTwo threadTwo = new ThreadTwo(resourceA, resourceB);

        // Start the threads
        threadOne.start();
        threadTwo.start();

        // The program will likely hang here due to the deadlock
        System.out.println("Main thread finished. Waiting for other threads (may hang due to deadlock).");
    }
}