package module4.deadlockexample;

public class DeadlockMain {

    public static void main(String[] args) {
        ResourceA resourceA = new ResourceA();
        ResourceB resourceB = new ResourceB();

        ThreadOne threadOne = new ThreadOne(resourceA, resourceB);
        ThreadTwo threadTwo = new ThreadTwo(resourceA, resourceB);

        threadOne.start();
        threadTwo.start();

        System.out.println("Основной поток окончен. Ожидание остальных потоков (могут зависнуть из-за deadlock).");
    }
}