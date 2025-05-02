package module4.alternatingoutput;

public class AlternatingOutputMain {

    public static void main(String[] args) {
        TurnManager turnManager = new TurnManager();

        ThreadOnePrinter threadOne = new ThreadOnePrinter(turnManager);
        ThreadTwoPrinter threadTwo = new ThreadTwoPrinter(turnManager);

        threadOne.start();
        threadTwo.start();

        System.out.println("Основной поток завершён. Запущены альтернативные потоки.");
    }
}