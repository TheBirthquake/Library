package module4.alternatingoutput;

public class ThreadTwoPrinter extends Thread {
    private TurnManager turnManager;

    public ThreadTwoPrinter(TurnManager turnManager) {
        this.turnManager = turnManager;
    }

    @Override
    public void run() {
        // Loop infinitely to keep printing
        while (true) {
            try {
                // Call the printTwo method on the shared TurnManager object
                turnManager.printTwo();
                // Add a small delay
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // Handle interruption if needed
                Thread.currentThread().interrupt(); // Restore the interrupted status
                break; // Exit the loop if interrupted
            }
        }
    }
}
