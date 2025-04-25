package module3.fileio;

public class Main {

    private static final String FILE_NAME = "mydata.txt";

    public static void main(String[] args) {
        FileDataManager fileManager = new FileDataManager(FILE_NAME);
        String dataToWrite = "Какая-то информация для записи внутрь создаваемого файла.\n" +
                "Это должна оказаться вторая строка этого файла.";

        try {
            fileManager.writeToFile(dataToWrite);
        } catch (CustomFileOperationException e) {
            System.err.println("При записи файла возникла ошибка:");
            e.printStackTrace();
        }

        System.out.println("\n--- Происходит чтение данных из файла ---");

        try {
            String readData = fileManager.readFromFile();
            System.out.println("В файле указано следующее:\n" + readData);
        } catch (CustomFileOperationException e) {
            System.err.println("Произошла ошибка при чтении файла:");
            e.printStackTrace();
        }

        System.out.println("\n--- Демонстрация error-handling'а (симулировано) ---");
        FileDataManager nonExistentFileManager = new FileDataManager("non_existent_file.txt");
        try {
            nonExistentFileManager.readFromFile(); // This would likely throw an exception
        } catch (CustomFileOperationException e) {
            System.err.println("Получена ожидаемая ошибка при попытке чтения несуществующего фалйа:");
            System.err.println("Сообщение: " + e.getMessage());
            System.err.println("Причина: " + e.getCause()); // Show the underlying IOException
        }
    }
}
