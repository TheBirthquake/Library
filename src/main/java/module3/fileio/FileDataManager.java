package module3.fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileDataManager {

    private final String filePath;

    public FileDataManager(String filePath) {
        this.filePath = filePath;
    }


    public void writeToFile(String data) throws CustomFileOperationException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(data);
            System.out.println("Информация успешно записана в файл " + filePath);
        } catch (IOException e) {
            throw new CustomFileOperationException("Ошибка при записи в файл: " + filePath, e);
        }
    }


    public String readFromFile() throws CustomFileOperationException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            System.out.println("Успешное чтение данных из " + filePath);
        } catch (IOException e) {
            throw new CustomFileOperationException("Ошибка при чтении данных из файла: " + filePath, e);
        }
        if (content.length() > 0) {
            content.setLength(content.length() - 1);
        }
        return content.toString();
    }
}
