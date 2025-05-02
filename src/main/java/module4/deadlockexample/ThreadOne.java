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
        synchronized (resourceA) {
            System.out.println("Поток 1: Заполучен " + resourceA.getName());

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (resourceB) {
                System.out.println("Поток 1: Заполучен " + resourceB.getName());
                System.out.println("Поток 1: Произведение действия с обоими ресурсами.");
            }
        }
    }
}
