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
        synchronized (resourceB) {
            System.out.println("Поток 2: Заполучен " + resourceB.getName());

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (resourceA) {
                System.out.println("Поток 2: Заполучен " + resourceA.getName());
                System.out.println("Поток 2: Произведение действия с обоими ресурсами.");
            }
        }
    }
}
