package module4.alternatingoutput;

public class AlternatingOutputMain {

    public static void main(String[] args) {
        // Create the shared TurnManager object
        TurnManager turnManager = new TurnManager();

        // Create the two threads, passing the shared TurnManager
        ThreadOnePrinter threadOne = new ThreadOnePrinter(turnManager);
        ThreadTwoPrinter threadTwo = new ThreadTwoPrinter(turnManager);

        // Start the threads
        threadOne.start();
        threadTwo.start();

        // The main thread can continue or wait, but the other threads will run infinitely
        System.out.println("Main thread finished. Alternating output started.");
    }
}