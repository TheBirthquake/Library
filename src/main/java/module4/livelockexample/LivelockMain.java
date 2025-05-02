package module4.livelockexample;

public class LivelockMain {

    public static void main(String[] args) {
        final Diner alphonse = new Diner("Альфонзо");
        final Diner gaston = new Diner("Гастон");

        final Spoon spoon = new Spoon(alphonse);

        Thread alphonseThread = new Thread(new Runnable() {
            @Override
            public void run() {
                alphonse.eatWith(spoon, gaston);
            }
        });

        Thread gastonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                gaston.eatWith(spoon, alphonse);
            }
        });

        alphonseThread.start();
        gastonThread.start();

        System.out.println("Основной поток завершён. Запущен сценарий Livelock.");
    }
}
