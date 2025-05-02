package module4.alternatingoutput;

public class TurnManager {
    private volatile boolean isTurnOne = true;

    public synchronized void printOne() throws InterruptedException {
        while (!isTurnOne) {
            wait();
        }
        System.out.println("1");
        isTurnOne = false;
        notifyAll();
    }


    public synchronized void printTwo() throws InterruptedException {
        while (isTurnOne) {
            wait();
        }
        System.out.println("2");
        isTurnOne = true;
        notifyAll();
    }
}
