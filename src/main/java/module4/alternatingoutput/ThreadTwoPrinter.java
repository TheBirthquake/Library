package module4.alternatingoutput;

public class ThreadTwoPrinter extends Thread {
    private TurnManager turnManager;

    public ThreadTwoPrinter(TurnManager turnManager) {
        this.turnManager = turnManager;
    }

    @Override
    public void run() {
        while (true) {
            try {
                turnManager.printTwo();
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
