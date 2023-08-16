package persistText;
import java.io.IOException;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        String content = "Conteúdo a ser persistido no arquivo";

        try {
            FileWriter reader = new FileWriter("archive.txt");
            reader.write(content);
            reader.close();
            System.out.println("data sucessfuly persisted");

        } catch (IOException e) {
            System.err.println("error: " + e.getMessage());
        }
    }
}
