package module4.alternatingoutput;

public class TurnManager {
    // Use a volatile boolean to indicate whose turn it is.
    // volatile ensures that changes to this variable are immediately visible to all threads.
    private volatile boolean isTurnOne = true;

    // Method for Thread One to wait for its turn and then print
    public synchronized void printOne() throws InterruptedException {
        // While it's not Thread One's turn, wait.
        // The wait() method releases the lock on this object and waits until notify() or notifyAll() is called.
        while (!isTurnOne) {
            wait();
        }
        // If it is Thread One's turn, print "1"
        System.out.println("1");
        // Change the turn to Thread Two
        isTurnOne = false;
        // Notify waiting threads (specifically Thread Two) that the turn has changed.
        notifyAll(); // Use notifyAll() to wake up all waiting threads, they will re-check the condition.
    }

    // Method for Thread Two to wait for its turn and then print
    public synchronized void printTwo() throws InterruptedException {
        // While it's not Thread Two's turn, wait.
        while (isTurnOne) {
            wait();
        }
        // If it is Thread Two's turn, print "2"
        System.out.println("2");
        // Change the turn to Thread One
        isTurnOne = true;
        // Notify waiting threads (specifically Thread One) that the turn has changed.
        notifyAll();
    }
}
