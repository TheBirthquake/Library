package module4.alternatingoutput;

public class ThreadOnePrinter extends Thread {
    private TurnManager turnManager;

    public ThreadOnePrinter(TurnManager turnManager) {
        this.turnManager = turnManager;
    }

    @Override
    public void run() {
        while (true) {
            try {
                turnManager.printOne();
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
