package module4.alternatingoutput;

public class ThreadOnePrinter extends Thread {
    private TurnManager turnManager;

    public ThreadOnePrinter(TurnManager turnManager) {
        this.turnManager = turnManager;
    }

    @Override
    public void run() {
        // Loop infinitely to keep printing
        while (true) {
            try {
                // Call the printOne method on the shared TurnManager object
                turnManager.printOne();
                // Add a small delay to make the output more visible and prevent busy waiting
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // Handle interruption if needed
                Thread.currentThread().interrupt(); // Restore the interrupted status
                break; // Exit the loop if interrupted
            }
        }
    }
}
